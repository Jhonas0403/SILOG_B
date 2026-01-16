package com.silog.silog_user.application.service.Brand;

import com.silog.silog_user.domain.model.Brand;
import com.silog.silog_user.domain.port.in.Brand.GetBrandUseCase;
import com.silog.silog_user.domain.port.out.BrandRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBrandService  implements GetBrandUseCase {
    public final BrandRepositoryPort brandRepository;
    public GetBrandService(BrandRepositoryPort brandRepository) {
        this.brandRepository = brandRepository;
    }
    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
