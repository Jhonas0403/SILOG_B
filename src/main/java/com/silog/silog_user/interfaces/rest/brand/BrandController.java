package com.silog.silog_user.interfaces.rest.brand;

import com.silog.silog_user.domain.model.Brand;
import com.silog.silog_user.domain.port.in.Brand.CreateBrandUseCase;
import com.silog.silog_user.domain.port.in.Brand.GetBrandUseCase;
import com.silog.silog_user.interfaces.rest.brand.dto.BrandRequest;
import com.silog.silog_user.interfaces.rest.brand.dto.BrandResponse;
import org.springframework.http.ResponseEntity;
import com.silog.silog_user.infrastructure.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        UUID storeId = getStoreIdFromJwt();
        List<Brand> brands = getBrandUseCase.getBrands(storeId);
        return ResponseEntity.ok(brands.stream().map(BrandResponse::fromDomain).toList());
    }

    @PostMapping
    public ResponseEntity<BrandResponse> addBrand(@RequestBody BrandRequest brand) {
        Brand dom = brand.toDomain();
        dom.setStoreId(getStoreIdFromJwt());
        Brand createdBrand = createBrandUseCase.create(dom);

        return ResponseEntity.ok(BrandResponse.fromDomain(createdBrand));
    }

    private UUID getStoreIdFromJwt() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        return principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
    }
}
