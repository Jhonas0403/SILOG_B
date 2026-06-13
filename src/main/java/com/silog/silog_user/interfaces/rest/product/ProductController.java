package com.silog.silog_user.interfaces.rest.product;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.domain.port.in.Products.CreateProductUseCase;
import com.silog.silog_user.domain.port.in.Products.GetProductByIdUseCase;
import com.silog.silog_user.domain.port.in.Products.GetProductUseCase;
import com.silog.silog_user.interfaces.rest.product.dto.ProductRequest;
import com.silog.silog_user.interfaces.rest.product.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import com.silog.silog_user.infrastructure.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductUseCase getProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase,GetProductUseCase getProductUseCase, GetProductByIdUseCase getProductByIdUseCase) {
        this.getProductUseCase = getProductUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.createProductUseCase = createProductUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(){
        UUID storeId = getStoreIdFromJwt();
        List<Product> products = getProductUseCase.getProducts(storeId);
        return ResponseEntity.ok(products.stream().map(ProductResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID id){
        Product product = getProductByIdUseCase.getProductById(id);
        return ResponseEntity.ok(ProductResponse.fromDomain(product));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest product){
        Product dom = product.toDomain();
        dom.setStoreId(getStoreIdFromJwt());
        Product createdProduct = createProductUseCase.create(dom);
        return ResponseEntity.ok(ProductResponse.fromDomain(createdProduct));
    }

    private UUID getStoreIdFromJwt() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        return principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
    }
}
