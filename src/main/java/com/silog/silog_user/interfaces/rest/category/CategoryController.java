package com.silog.silog_user.interfaces.rest.category;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.domain.port.in.Category.CreateCategoryUseCase;
import com.silog.silog_user.domain.port.in.Category.GetCategoryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = getCategoryUseCase.getCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category crateCategory = createCategoryUseCase.create(category);
        return ResponseEntity.ok(crateCategory);
    }
}
