package com.silog.silog_user.application.service.SaleDetail;

import com.silog.silog_user.domain.model.SaleDetail;
import com.silog.silog_user.domain.port.in.SaleDetail.CreateSaleDetailUseCase;
import com.silog.silog_user.domain.port.out.SaleDetailRepositoryPort;
import com.silog.silog_user.domain.port.out.SaleRepositoryPort;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateSaleDetailService implements CreateSaleDetailUseCase {
    private final SaleDetailRepositoryPort saleDetailRepositoryPort;
    private final SaleRepositoryPort saleRepositoryPort;
    private final VariantRepositoryPort variantRepositoryPort;

    public CreateSaleDetailService(
            SaleDetailRepositoryPort saleDetailRepositoryPort,
            SaleRepositoryPort saleRepositoryPort,
            VariantRepositoryPort variantRepositoryPort
    ) {
        this.saleDetailRepositoryPort = saleDetailRepositoryPort;
        this.saleRepositoryPort = saleRepositoryPort;
        this.variantRepositoryPort = variantRepositoryPort;
    }

    @Override
    public SaleDetail create(SaleDetail saleDetail) {
        validate(saleDetail);

        if (saleRepositoryPort.findById(saleDetail.getSaleId()) == null) {
            throw new RuntimeException("Sale not found");
        }
        if (variantRepositoryPort.findById(saleDetail.getVariantId()) == null) {
            throw new RuntimeException("Variant not found");
        }

        saleDetail.setSubtotal(saleDetail.getSalePrice() * saleDetail.getQuantity());
        if (saleDetail.getStatus() == null) {
            saleDetail.setStatus(true);
        }
        if (saleDetail.getUpdatedBy() == null) {
            saleDetail.setUpdatedBy(saleDetail.getCreatedBy());
        }
        saleDetail.setCreatedAt(LocalDateTime.now());
        saleDetail.setUpdatedAt(LocalDateTime.now());
        return saleDetailRepositoryPort.save(saleDetail);
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
        if (saleDetail.getSalePrice() == null || saleDetail.getSalePrice() < 0) {
            throw new RuntimeException("Sale price must be greater than or equal to zero");
        }
        if (saleDetail.getPurchasePrice() == null || saleDetail.getPurchasePrice() < 0) {
            throw new RuntimeException("Purchase price must be greater than or equal to zero");
        }
    }
}
