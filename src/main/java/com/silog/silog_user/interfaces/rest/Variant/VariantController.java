package com.silog.silog_user.interfaces.rest.Variant;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.Variant.CreateVariantUseCase;
import com.silog.silog_user.domain.port.in.Variant.GetVariantUseCase;
import com.silog.silog_user.interfaces.rest.Variant.dto.VariantRequest;
import com.silog.silog_user.interfaces.rest.Variant.dto.VariantResponse;
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
        UUID storeId = getStoreIdFromJwt();
        List<Variant> variants = getVariantUseCase.getVariants(storeId);
        return ResponseEntity.ok(variants.stream().map(VariantResponse::fromDomain).toList());
    }

    @PostMapping
    public ResponseEntity<VariantResponse>  createVariant(@RequestBody VariantRequest variant) {
        Variant dom = variant.toDomain();
        dom.setStoreId(getStoreIdFromJwt());
        Variant createVariant = createVariantUseCase.create(dom);
        return ResponseEntity.ok(VariantResponse.fromDomain(createVariant));
    }

    private UUID getStoreIdFromJwt() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        return principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
    }
}
