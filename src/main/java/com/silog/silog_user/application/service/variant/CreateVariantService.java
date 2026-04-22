package com.silog.silog_user.application.service.variant;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.Variant.CreateVariantUseCase;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateVariantService  implements CreateVariantUseCase {
    private final VariantRepositoryPort variantRepositoryPort;

    public CreateVariantService(VariantRepositoryPort variantRepositoryPort) {
        this.variantRepositoryPort = variantRepositoryPort;
    }

    @Override
    public Variant create(Variant variant) {
        Integer nextOrder = variantRepositoryPort.findMaxOrder() + 1;
        variant.setOrder(nextOrder);

        return  variantRepositoryPort.save(variant);
    }

}
