package com.silog.silog_user.interfaces.rest.saledetail;

import com.silog.silog_user.domain.model.SaleDetail;
import com.silog.silog_user.domain.port.in.SaleDetail.CreateSaleDetailUseCase;
import com.silog.silog_user.domain.port.in.SaleDetail.GetSaleDetailByIdUseCase;
import com.silog.silog_user.domain.port.in.SaleDetail.GetSaleDetailsUseCase;
import com.silog.silog_user.interfaces.rest.saledetail.dto.SaleDetailRequest;
import com.silog.silog_user.interfaces.rest.saledetail.dto.SaleDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sale-details")
public class SaleDetailController {
    private final CreateSaleDetailUseCase createSaleDetailUseCase;
    private final GetSaleDetailsUseCase getSaleDetailsUseCase;
    private final GetSaleDetailByIdUseCase getSaleDetailByIdUseCase;

    public SaleDetailController(
            CreateSaleDetailUseCase createSaleDetailUseCase,
            GetSaleDetailsUseCase getSaleDetailsUseCase,
            GetSaleDetailByIdUseCase getSaleDetailByIdUseCase
    ) {
        this.createSaleDetailUseCase = createSaleDetailUseCase;
        this.getSaleDetailsUseCase = getSaleDetailsUseCase;
        this.getSaleDetailByIdUseCase = getSaleDetailByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<SaleDetailResponse>> getSaleDetails() {
        List<SaleDetail> saleDetails = getSaleDetailsUseCase.getSaleDetails();
        return ResponseEntity.ok(saleDetails.stream().map(SaleDetailResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDetailResponse> getSaleDetailById(@PathVariable UUID id) {
        SaleDetail saleDetail = getSaleDetailByIdUseCase.getSaleDetailById(id);
        return ResponseEntity.ok(SaleDetailResponse.fromDomain(saleDetail));
    }

    @PostMapping
    public ResponseEntity<SaleDetailResponse> createSaleDetail(@RequestBody SaleDetailRequest saleDetail) {
        SaleDetail createdSaleDetail = createSaleDetailUseCase.create(saleDetail.toDomain());
        return ResponseEntity.ok(SaleDetailResponse.fromDomain(createdSaleDetail));
    }
}
