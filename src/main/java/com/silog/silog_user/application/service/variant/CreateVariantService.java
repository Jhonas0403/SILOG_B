package com.silog.silog_user.application.service.variant;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.Variant.CreateVariantUseCase;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateVariantService implements CreateVariantUseCase {
    private final VariantRepositoryPort variantRepositoryPort;

    public CreateVariantService(VariantRepositoryPort variantRepositoryPort) {
        this.variantRepositoryPort = variantRepositoryPort;
    }

    @Override
    public Variant create(Variant variant) {
        Integer nextOrder = variantRepositoryPort.findMaxOrderByStoreId(variant.getStoreId()) + 1;
        if (variant.getStatus() == null) {
            variant.setStatus(true);
        }
        if (variant.getStock() == null) {
            variant.setStock(0);
        }
        // BUG FIX: use BigDecimal.ZERO instead of 0.0 (double literal)
        if (variant.getPurchasePrice() == null) {
            variant.setPurchasePrice(BigDecimal.ZERO);
        }
        if (variant.getSalePrice() == null) {
            variant.setSalePrice(BigDecimal.ZERO);
        }
        if (variant.getMinSalePrice() == null) {
            variant.setMinSalePrice(BigDecimal.ZERO);
        }
        variant.setOrder(nextOrder);
        // Note: audit fields are set automatically by AuditingEntityListener
        return variantRepositoryPort.save(variant);
    }
}
