package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.PaymentMethod;
import com.silog.silog_user.domain.port.out.PaymentMethodRepositoryPort;
import com.silog.silog_user.infrastructure.entity.PaymentMethodEntity;
import com.silog.silog_user.infrastructure.mapper.PaymentMethodMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaPaymentMethodRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PaymentMethodRepositoryAdapter implements PaymentMethodRepositoryPort {

    private final JpaPaymentMethodRepository jpaPaymentMethodRepository;

    public PaymentMethodRepositoryAdapter(JpaPaymentMethodRepository jpaPaymentMethodRepository) {
        this.jpaPaymentMethodRepository = jpaPaymentMethodRepository;
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        PaymentMethodEntity entity = PaymentMethodMapper.toEntity(paymentMethod);
        return PaymentMethodMapper.toDomain(jpaPaymentMethodRepository.save(entity));
    }

    @Override
    public List<PaymentMethod> findAll() {
        return jpaPaymentMethodRepository.findAll()
                .stream()
                .map(PaymentMethodMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<PaymentMethod> findById(UUID id) {
        return jpaPaymentMethodRepository.findById(id)
                .map(PaymentMethodMapper::toDomain);
    }
}
