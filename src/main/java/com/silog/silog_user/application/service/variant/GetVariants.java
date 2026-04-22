package com.silog.silog_user.application.service.variant;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.Variant.GetVariantUseCase;
import com.silog.silog_user.domain.port.out.ProductRepositoryPort;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetVariants implements GetVariantUseCase {

    public final VariantRepositoryPort variantRepository;
    public GetVariants(VariantRepositoryPort variantRepository) {
        this.variantRepository = variantRepository;
    }
    @Override
    public List<Variant> getVariants() {
        return variantRepository.findAll();
    }

}
