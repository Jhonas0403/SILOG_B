package com.silog.silog_user.application.service.Brand;

import com.silog.silog_user.domain.model.Brand;
import com.silog.silog_user.domain.port.in.Brand.CreateBrandUseCase;
import com.silog.silog_user.domain.port.out.BrandRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateBrandService implements CreateBrandUseCase {
    public final BrandRepositoryPort brandRepositoryPort;
    public CreateBrandService(BrandRepositoryPort brandRepositoryPort) {
        this.brandRepositoryPort = brandRepositoryPort;
    }

    @Override
    public Brand create(Brand brand) {
        return brandRepositoryPort.save(brand);
    }
}
