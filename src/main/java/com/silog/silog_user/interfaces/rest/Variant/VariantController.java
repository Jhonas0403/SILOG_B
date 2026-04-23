package com.silog.silog_user.interfaces.rest.Variant;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.Variant.CreateVariantUseCase;
import com.silog.silog_user.domain.port.in.Variant.GetVariantUseCase;
import com.silog.silog_user.interfaces.rest.Variant.dto.VariantRequest;
import com.silog.silog_user.interfaces.rest.Variant.dto.VariantResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/variant")
public class VariantController {
    private final GetVariantUseCase getVariantUseCase;
    private final CreateVariantUseCase createVariantUseCase;

    public VariantController(GetVariantUseCase getVariantUseCase, CreateVariantUseCase createVariantUseCase) {
        this.getVariantUseCase = getVariantUseCase;
        this.createVariantUseCase = createVariantUseCase;
    }

    @GetMapping
    public ResponseEntity<List<VariantResponse>> getVariants() {
        List<Variant> variants = getVariantUseCase.getVariants();
        return ResponseEntity.ok(variants.stream().map(VariantResponse::fromDomain).toList());
    }

    @PostMapping
    public ResponseEntity<VariantResponse>  createVariant(@RequestBody VariantRequest variant) {
        Variant createVariant = createVariantUseCase.create(variant.toDomain());
        return ResponseEntity.ok(VariantResponse.fromDomain(createVariant));
    }
}
