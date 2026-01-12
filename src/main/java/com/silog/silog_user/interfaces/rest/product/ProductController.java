package com.silog.silog_user.interfaces.rest.product;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.domain.port.in.Products.GetProductByIdUseCase;
import com.silog.silog_user.domain.port.in.Products.GetProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductUseCase getProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;

    public ProductController(GetProductUseCase getProductUseCase, GetProductByIdUseCase getProductByIdUseCase) {
        this.getProductUseCase = getProductUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = getProductUseCase.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id){
        Product product = getProductByIdUseCase.getProductById(id);
        return ResponseEntity.ok(product);
    }
}
