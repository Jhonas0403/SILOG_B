package com.silog.silog_user.interfaces.rest.brand;

import com.silog.silog_user.domain.model.Brand;
import com.silog.silog_user.domain.port.in.Brand.CreateBrandUseCase;
import com.silog.silog_user.domain.port.in.Brand.GetBrandUseCase;
import com.silog.silog_user.interfaces.rest.brand.dto.BrandRequest;
import com.silog.silog_user.interfaces.rest.brand.dto.BrandResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    private final GetBrandUseCase getBrandUseCase;
    private final CreateBrandUseCase createBrandUseCase;

    public BrandController(CreateBrandUseCase createBrandUseCase,GetBrandUseCase getBrandUseCase) {
        this.getBrandUseCase = getBrandUseCase;
        this.createBrandUseCase = createBrandUseCase;
    }

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getBrands() {
        List<Brand> brands = getBrandUseCase.getBrands();
        return ResponseEntity.ok(brands.stream().map(BrandResponse::fromDomain).toList());
    }

    @PostMapping
    public ResponseEntity<BrandResponse> addBrand(@RequestBody BrandRequest brand) {
        Brand createdBrand = createBrandUseCase.create(brand.toDomain());

        return ResponseEntity.ok(BrandResponse.fromDomain(createdBrand));
    }
}
