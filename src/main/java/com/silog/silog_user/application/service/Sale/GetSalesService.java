package com.silog.silog_user.application.service.Sale;

import com.silog.silog_user.domain.model.Sale;
import com.silog.silog_user.domain.port.in.Sale.GetSalesUseCase;
import com.silog.silog_user.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetSalesService implements GetSalesUseCase {
    private final SaleRepositoryPort saleRepositoryPort;

    public GetSalesService(SaleRepositoryPort saleRepositoryPort) {
        this.saleRepositoryPort = saleRepositoryPort;
    }

    @Override
    public List<Sale> getSales(UUID storeId) {
        if (storeId != null) {
            return saleRepositoryPort.findByStoreId(storeId);
        }
        return saleRepositoryPort.findAll();
    }
}
