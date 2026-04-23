package com.silog.silog_user.application.service.SaleDetail;

import com.silog.silog_user.domain.model.SaleDetail;
import com.silog.silog_user.domain.port.in.SaleDetail.GetSaleDetailByIdUseCase;
import com.silog.silog_user.domain.port.out.SaleDetailRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetSaleDetailByIdService implements GetSaleDetailByIdUseCase {
    private final SaleDetailRepositoryPort saleDetailRepositoryPort;

    public GetSaleDetailByIdService(SaleDetailRepositoryPort saleDetailRepositoryPort) {
        this.saleDetailRepositoryPort = saleDetailRepositoryPort;
    }

    @Override
    public SaleDetail getSaleDetailById(UUID id) {
        return saleDetailRepositoryPort.findById(id);
    }
}
