package com.silog.silog_user.interfaces.rest.subcategory;

import com.silog.silog_user.domain.model.Subcategory;
import com.silog.silog_user.domain.port.in.Subcategory.CreateSubcategoryUseCase;
import com.silog.silog_user.domain.port.in.Subcategory.GetSubcategoryUseCase;
import com.silog.silog_user.interfaces.rest.subcategory.dto.SubcategoryRequest;
import com.silog.silog_user.interfaces.rest.subcategory.dto.SubcategoryResponse;
import org.springframework.http.ResponseEntity;
import com.silog.silog_user.infrastructure.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {
    private final GetSubcategoryUseCase getSubcategoryUseCase;
    private final CreateSubcategoryUseCase createSubcategoryUseCase;


    public SubcategoryController(GetSubcategoryUseCase getSubcategoryUseCase, CreateSubcategoryUseCase createSubcategoryUseCase) {
        this.getSubcategoryUseCase = getSubcategoryUseCase;
        this.createSubcategoryUseCase = createSubcategoryUseCase;
    }

    @GetMapping
    public ResponseEntity<List<SubcategoryResponse>> getSubcategories() {
        UUID storeId = getStoreIdFromJwt();
        List<Subcategory> subcategories = getSubcategoryUseCase.getSubcategories(storeId);
        return ResponseEntity.ok(subcategories.stream().map(SubcategoryResponse::fromDomain).toList());
    }

    @PostMapping
    public ResponseEntity<SubcategoryResponse> createSubcategory(@RequestBody SubcategoryRequest subcategory) {

        Subcategory dom = subcategory.toDomain();
        dom.setStoreId(getStoreIdFromJwt());
        Subcategory createSubcategory = createSubcategoryUseCase.create(dom);
        return ResponseEntity.ok(SubcategoryResponse.fromDomain(createSubcategory));
    }

    private UUID getStoreIdFromJwt() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        return principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
    }
}
