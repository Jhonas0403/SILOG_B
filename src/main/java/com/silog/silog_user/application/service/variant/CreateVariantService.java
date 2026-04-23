package com.silog.silog_user.application.service.variant;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.Variant.CreateVariantUseCase;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateVariantService  implements CreateVariantUseCase {
    private final VariantRepositoryPort variantRepositoryPort;

    public CreateVariantService(VariantRepositoryPort variantRepositoryPort) {
        this.variantRepositoryPort = variantRepositoryPort;
    }

    @Override
    public Variant create(Variant variant) {
        Integer nextOrder = variantRepositoryPort.findMaxOrder() + 1;
        if (variant.getStatus() == null) {
            variant.setStatus(true);
        }
        if (variant.getStock() == null) {
            variant.setStock(0);
        }
        if (variant.getPurchasePrice() == null) {
            variant.setPurchasePrice(0.0);
        }
        if (variant.getSalePrice() == null) {
            variant.setSalePrice(0.0);
        }
        if (variant.getMinSalePrice() == null) {
            variant.setMinSalePrice(0.0);
        }
        if (variant.getUpdatedBy() == null) {
            variant.setUpdatedBy(variant.getCreatedBy());
        }
        variant.setCreatedAt(LocalDateTime.now());
        variant.setUpdatedAt(LocalDateTime.now());
        variant.setOrder(nextOrder);

        return  variantRepositoryPort.save(variant);
    }

}
