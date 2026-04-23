package com.silog.silog_user.interfaces.rest.sale;

import com.silog.silog_user.domain.model.Sale;
import com.silog.silog_user.domain.port.in.Sale.CreateSaleUseCase;
import com.silog.silog_user.domain.port.in.Sale.GetSaleByIdUseCase;
import com.silog.silog_user.domain.port.in.Sale.GetSalesUseCase;
import com.silog.silog_user.interfaces.rest.sale.dto.SaleRequest;
import com.silog.silog_user.interfaces.rest.sale.dto.SaleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final CreateSaleUseCase createSaleUseCase;
    private final GetSalesUseCase getSalesUseCase;
    private final GetSaleByIdUseCase getSaleByIdUseCase;

    public SaleController(
            CreateSaleUseCase createSaleUseCase,
            GetSalesUseCase getSalesUseCase,
            GetSaleByIdUseCase getSaleByIdUseCase
    ) {
        this.createSaleUseCase = createSaleUseCase;
        this.getSalesUseCase = getSalesUseCase;
        this.getSaleByIdUseCase = getSaleByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<SaleResponse>> getSales() {
        List<Sale> sales = getSalesUseCase.getSales();
        return ResponseEntity.ok(sales.stream().map(SaleResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> getSaleById(@PathVariable UUID id) {
        Sale sale = getSaleByIdUseCase.getSaleById(id);
        return ResponseEntity.ok(SaleResponse.fromDomain(sale));
    }

    @PostMapping
    public ResponseEntity<SaleResponse> createSale(@RequestBody SaleRequest sale) {
        Sale createdSale = createSaleUseCase.create(sale.toDomain());
        return ResponseEntity.ok(SaleResponse.fromDomain(createdSale));
    }
}
