package com.silog.silog_user.interfaces.rest.subcategory;

import com.silog.silog_user.domain.model.Subcategory;
import com.silog.silog_user.domain.port.in.Subcategory.CreateSubcategoryUseCase;
import com.silog.silog_user.domain.port.in.Subcategory.GetSubcategoryUseCase;
import com.silog.silog_user.interfaces.rest.subcategory.dto.SubcategoryRequest;
import com.silog.silog_user.interfaces.rest.subcategory.dto.SubcategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        List<Subcategory> subcategories = getSubcategoryUseCase.getSubcategories();
        return ResponseEntity.ok(subcategories.stream().map(SubcategoryResponse::fromDomain).toList());
    }

    @PostMapping
    public ResponseEntity<SubcategoryResponse> createSubcategory(@RequestBody SubcategoryRequest subcategory) {

        Subcategory createSubcategory = createSubcategoryUseCase.create(subcategory.toDomain());
        return ResponseEntity.ok(SubcategoryResponse.fromDomain(createSubcategory));
    }
}
