package com.silog.silog_user.application.service.Sale;

import com.silog.silog_user.domain.model.Sale;
import com.silog.silog_user.domain.port.in.Sale.GetSaleByIdUseCase;
import com.silog.silog_user.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetSaleByIdService implements GetSaleByIdUseCase {
    private final SaleRepositoryPort saleRepositoryPort;

    public GetSaleByIdService(SaleRepositoryPort saleRepositoryPort) {
        this.saleRepositoryPort = saleRepositoryPort;
    }

    @Override
    public Sale getSaleById(UUID id) {
        return saleRepositoryPort.findById(id);
    }
}
