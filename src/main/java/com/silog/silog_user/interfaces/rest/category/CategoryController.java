package com.silog.silog_user.interfaces.rest.category;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.domain.port.in.Category.GetCategoryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final GetCategoryUseCase getCategoryUseCase;

    public CategoryController(GetCategoryUseCase getCategoryUseCase) {
        this.getCategoryUseCase = getCategoryUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = getCategoryUseCase.getCategories();
        return ResponseEntity.ok(categories);
    }
}
