package com.silog.silog_user.application.service.Sale;

import com.silog.silog_user.domain.exception.ResourceNotFoundException;
import com.silog.silog_user.domain.model.Sale;
import com.silog.silog_user.domain.port.in.Sale.CreateSaleUseCase;
import com.silog.silog_user.domain.port.out.PaymentMethodRepositoryPort;
import com.silog.silog_user.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class CreateSaleService implements CreateSaleUseCase {

    private final SaleRepositoryPort saleRepositoryPort;
    private final PaymentMethodRepositoryPort paymentMethodRepositoryPort;

    public CreateSaleService(SaleRepositoryPort saleRepositoryPort,
                             PaymentMethodRepositoryPort paymentMethodRepositoryPort) {
        this.saleRepositoryPort = saleRepositoryPort;
        this.paymentMethodRepositoryPort = paymentMethodRepositoryPort;
    }

    @Override
    public Sale create(Sale sale) {
        if (sale.getTotal() == null || sale.getTotal().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El total de la venta debe ser mayor o igual a cero");
        }
        if (sale.getPaymentMethodId() == null) {
            throw new IllegalArgumentException("Se debe especificar un método de pago");
        }
        paymentMethodRepositoryPort.findById(sale.getPaymentMethodId())
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago no encontrado"));

        if (sale.getSaleDate() == null) {
            sale.setSaleDate(ZonedDateTime.now(ZoneId.of("America/Lima")));
        }
        if (sale.getStatus() == null) {
            sale.setStatus(true);
        }
        return saleRepositoryPort.save(sale);
    }
}
