package com.silog.silog_user.application.service.Sale;

import com.silog.silog_user.domain.model.Sale;
import com.silog.silog_user.domain.port.in.Sale.CreateSaleUseCase;
import com.silog.silog_user.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateSaleService implements CreateSaleUseCase {
    private final SaleRepositoryPort saleRepositoryPort;

    public CreateSaleService(SaleRepositoryPort saleRepositoryPort) {
        this.saleRepositoryPort = saleRepositoryPort;
    }

    @Override
    public Sale create(Sale sale) {
        if (sale.getTotal() == null || sale.getTotal() < 0) {
            throw new RuntimeException("Sale total must be greater than or equal to zero");
        }
        if (sale.getSaleDate() == null) {
            sale.setSaleDate(LocalDateTime.now());
        }
        if (sale.getStatus() == null) {
            sale.setStatus(true);
        }
        if (sale.getUpdatedBy() == null) {
            sale.setUpdatedBy(sale.getCreatedBy());
        }
        sale.setCreatedAt(LocalDateTime.now());
        sale.setUpdatedAt(LocalDateTime.now());
        return saleRepositoryPort.save(sale);
    }
}
