package com.silog.silog_user.interfaces.rest.category;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.domain.port.in.Category.CreateCategoryUseCase;
import com.silog.silog_user.domain.port.in.Category.GetCategoryUseCase;
import com.silog.silog_user.interfaces.rest.category.dto.CategoryRequest;
import com.silog.silog_user.interfaces.rest.category.dto.CategoryResponse;
import org.springframework.http.ResponseEntity;
import com.silog.silog_user.infrastructure.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final GetCategoryUseCase getCategoryUseCase;
    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase ,GetCategoryUseCase getCategoryUseCase) {
        this.getCategoryUseCase = getCategoryUseCase;
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        UUID storeId = getStoreIdFromJwt();
        List<Category> categories = getCategoryUseCase.getCategories(storeId);
        return ResponseEntity.ok(categories.stream().map(CategoryResponse::fromDomain).toList());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest category) {
        Category dom = category.toDomain();
        dom.setStoreId(getStoreIdFromJwt());
        Category crateCategory = createCategoryUseCase.create(dom);
        return ResponseEntity.ok(CategoryResponse.fromDomain(crateCategory));
    }

    private UUID getStoreIdFromJwt() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        return principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
    }
}
