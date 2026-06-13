package com.silog.silog_user.application.service.SaleDetail;

import com.silog.silog_user.domain.model.InventoryMovement;
import com.silog.silog_user.domain.model.SaleDetail;
import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.SaleDetail.CreateSaleDetailUseCase;
import com.silog.silog_user.domain.port.out.InventoryMovementRepositoryPort;
import com.silog.silog_user.domain.port.out.SaleDetailRepositoryPort;
import com.silog.silog_user.domain.port.out.SaleRepositoryPort;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateSaleDetailService implements CreateSaleDetailUseCase {
    private final SaleDetailRepositoryPort saleDetailRepositoryPort;
    private final SaleRepositoryPort saleRepositoryPort;
    private final VariantRepositoryPort variantRepositoryPort;
    private final InventoryMovementRepositoryPort inventoryMovementRepositoryPort;

    public CreateSaleDetailService(
            SaleDetailRepositoryPort saleDetailRepositoryPort,
            SaleRepositoryPort saleRepositoryPort,
            VariantRepositoryPort variantRepositoryPort,
            InventoryMovementRepositoryPort inventoryMovementRepositoryPort
    ) {
        this.saleDetailRepositoryPort = saleDetailRepositoryPort;
        this.saleRepositoryPort = saleRepositoryPort;
        this.variantRepositoryPort = variantRepositoryPort;
        this.inventoryMovementRepositoryPort = inventoryMovementRepositoryPort;
    }

    @Override
    public SaleDetail create(SaleDetail saleDetail) {
        validate(saleDetail);

        if (saleRepositoryPort.findById(saleDetail.getSaleId()) == null) {
            throw new RuntimeException("Sale not found");
        }

        Variant variant = variantRepositoryPort.findById(saleDetail.getVariantId());
        if (variant == null) {
            throw new RuntimeException("Variant not found");
        }

        int currentStock = variant.getStock() == null ? 0 : variant.getStock();
        int newStock = currentStock - saleDetail.getQuantity();
        if (newStock < 0) {
            throw new IllegalArgumentException(
                "Stock insuficiente para la variante. Stock actual: " + currentStock +
                ", cantidad solicitada: " + saleDetail.getQuantity()
            );
        }

        saleDetail.setSubtotal(
            saleDetail.getSalePrice().multiply(BigDecimal.valueOf(saleDetail.getQuantity()))
        );
        if (saleDetail.getStatus() == null) {
            saleDetail.setStatus(true);
        }

        SaleDetail saved = saleDetailRepositoryPort.save(saleDetail);

        variant.setStock(newStock);
        variantRepositoryPort.save(variant);

        InventoryMovement movement = new InventoryMovement();
        movement.setVariantId(saleDetail.getVariantId());
        movement.setMovementType("OUT");
        movement.setQuantity(saleDetail.getQuantity());
        movement.setSalePrice(saleDetail.getSalePrice());
        movement.setPurchasePrice(saleDetail.getPurchasePrice());
        movement.setReferenceType("SALE");
        movement.setReferenceId(saleDetail.getSaleId());
        movement.setStatus(true);
        inventoryMovementRepositoryPort.save(movement);

        return saved;
    }

    private void validate(SaleDetail saleDetail) {
        if (saleDetail.getSaleId() == null) {
            throw new RuntimeException("Sale is required");
        }
        if (saleDetail.getVariantId() == null) {
            throw new RuntimeException("Variant is required");
        }
        if (saleDetail.getQuantity() == null || saleDetail.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than zero");
        }
        // BUG FIX: BigDecimal comparison uses compareTo(), not < operator
        if (saleDetail.getSalePrice() == null || saleDetail.getSalePrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Sale price must be greater than or equal to zero");
        }
        if (saleDetail.getPurchasePrice() == null || saleDetail.getPurchasePrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Purchase price must be greater than or equal to zero");
        }
    }
}
