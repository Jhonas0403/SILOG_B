package com.silog.silog_user.application.service.PaymentMethod;

import com.silog.silog_user.domain.exception.ResourceNotFoundException;
import com.silog.silog_user.domain.model.PaymentMethod;
import com.silog.silog_user.domain.port.in.PaymentMethod.GetPaymentMethodByIdUseCase;
import com.silog.silog_user.domain.port.out.PaymentMethodRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetPaymentMethodByIdService implements GetPaymentMethodByIdUseCase {

    private final PaymentMethodRepositoryPort paymentMethodRepositoryPort;

    public GetPaymentMethodByIdService(PaymentMethodRepositoryPort paymentMethodRepositoryPort) {
        this.paymentMethodRepositoryPort = paymentMethodRepositoryPort;
    }

    @Override
    public PaymentMethod getById(UUID id) {
        return paymentMethodRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago no encontrado"));
    }
}
