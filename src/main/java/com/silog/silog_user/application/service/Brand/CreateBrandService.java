package com.silog.silog_user.application.service.Brand;

import com.silog.silog_user.domain.model.Brand;
import com.silog.silog_user.domain.port.in.Brand.CreateBrandUseCase;
import com.silog.silog_user.domain.port.out.BrandRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateBrandService implements CreateBrandUseCase {
    public final BrandRepositoryPort brandRepositoryPort;
    public CreateBrandService(BrandRepositoryPort brandRepositoryPort) {
        this.brandRepositoryPort = brandRepositoryPort;
    }

    @Override
    public Brand create(Brand brand) {
        Integer nextBrand = brandRepositoryPort.findMaxOrder() + 1;

        if (brand.getStatus() == null) {
            brand.setStatus(true);
        }
        if (brand.getUpdatedBy() == null) {
            brand.setUpdatedBy(brand.getCreatedBy());
        }
        brand.setCreatedAt(LocalDateTime.now());
        brand.setUpdatedAt(LocalDateTime.now());
        brand.setOrder(nextBrand);
        return brandRepositoryPort.save(brand);
    }
}
