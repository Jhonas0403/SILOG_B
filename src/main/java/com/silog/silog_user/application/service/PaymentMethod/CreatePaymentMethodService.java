package com.silog.silog_user.application.service.PaymentMethod;

import com.silog.silog_user.domain.model.PaymentMethod;
import com.silog.silog_user.domain.port.in.PaymentMethod.CreatePaymentMethodUseCase;
import com.silog.silog_user.domain.port.out.PaymentMethodRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreatePaymentMethodService implements CreatePaymentMethodUseCase {

    private final PaymentMethodRepositoryPort paymentMethodRepositoryPort;

    public CreatePaymentMethodService(PaymentMethodRepositoryPort paymentMethodRepositoryPort) {
        this.paymentMethodRepositoryPort = paymentMethodRepositoryPort;
    }

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        if (paymentMethod.getStatus() == null) {
            paymentMethod.setStatus(true);
        }
        if (paymentMethod.getRequiresOperationCode() == null) {
            paymentMethod.setRequiresOperationCode(false);
        }
        return paymentMethodRepositoryPort.save(paymentMethod);
    }
}
