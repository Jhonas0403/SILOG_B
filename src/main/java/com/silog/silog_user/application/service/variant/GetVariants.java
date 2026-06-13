package com.silog.silog_user.application.service.variant;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.Variant.GetVariantUseCase;
import com.silog.silog_user.domain.port.out.ProductRepositoryPort;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetVariants implements GetVariantUseCase {

    public final VariantRepositoryPort variantRepository;
    public GetVariants(VariantRepositoryPort variantRepository) {
        this.variantRepository = variantRepository;
    }
    @Override
    public List<Variant> getVariants(UUID storeId) {
        if (storeId != null) return variantRepository.findByStoreId(storeId);
        return variantRepository.findAll();
    }

}
