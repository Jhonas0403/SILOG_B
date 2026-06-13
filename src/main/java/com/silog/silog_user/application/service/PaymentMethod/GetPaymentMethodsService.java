package com.silog.silog_user.application.service.PaymentMethod;

import com.silog.silog_user.domain.model.PaymentMethod;
import com.silog.silog_user.domain.port.in.PaymentMethod.GetPaymentMethodsUseCase;
import com.silog.silog_user.domain.port.out.PaymentMethodRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPaymentMethodsService implements GetPaymentMethodsUseCase {

    private final PaymentMethodRepositoryPort paymentMethodRepositoryPort;

    public GetPaymentMethodsService(PaymentMethodRepositoryPort paymentMethodRepositoryPort) {
        this.paymentMethodRepositoryPort = paymentMethodRepositoryPort;
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepositoryPort.findAll();
    }
}
