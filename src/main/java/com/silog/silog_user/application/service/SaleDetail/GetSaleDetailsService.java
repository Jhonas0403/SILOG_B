package com.silog.silog_user.application.service.SaleDetail;

import com.silog.silog_user.domain.model.SaleDetail;
import com.silog.silog_user.domain.port.in.SaleDetail.GetSaleDetailsUseCase;
import com.silog.silog_user.domain.port.out.SaleDetailRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSaleDetailsService implements GetSaleDetailsUseCase {
    private final SaleDetailRepositoryPort saleDetailRepositoryPort;

    public GetSaleDetailsService(SaleDetailRepositoryPort saleDetailRepositoryPort) {
        this.saleDetailRepositoryPort = saleDetailRepositoryPort;
    }

    @Override
    public List<SaleDetail> getSaleDetails() {
        return saleDetailRepositoryPort.findAll();
    }
}
