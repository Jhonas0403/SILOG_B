package com.silog.silog_user.interfaces.rest.subcategory;

import com.silog.silog_user.domain.model.Subcategory;
import com.silog.silog_user.domain.port.in.Subcategory.CreateSubcategoryUseCase;
import com.silog.silog_user.domain.port.in.Subcategory.GetSubcategoryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subcategory")
public class SubcategoryController {
    private final GetSubcategoryUseCase getSubcategoryUseCase;
    private final CreateSubcategoryUseCase createSubcategoryUseCase;


    public SubcategoryController(GetSubcategoryUseCase getSubcategoryUseCase, CreateSubcategoryUseCase createSubcategoryUseCase) {
        this.getSubcategoryUseCase = getSubcategoryUseCase;
        this.createSubcategoryUseCase = createSubcategoryUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Subcategory>> getSubcategories() {
        List<Subcategory> subcategories = getSubcategoryUseCase.getSubcategories();
        return ResponseEntity.ok(subcategories);
    }

    @PostMapping
    public ResponseEntity<Subcategory> createSubcategory(@RequestBody Subcategory subcategory) {

        Subcategory createSubcategory = createSubcategoryUseCase.create(subcategory);
        return ResponseEntity.ok(createSubcategory);
    }
}
