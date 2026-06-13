package com.silog.silog_user.interfaces.rest.paymentmethod;

import com.silog.silog_user.domain.model.PaymentMethod;
import com.silog.silog_user.domain.port.in.PaymentMethod.CreatePaymentMethodUseCase;
import com.silog.silog_user.domain.port.in.PaymentMethod.GetPaymentMethodByIdUseCase;
import com.silog.silog_user.domain.port.in.PaymentMethod.GetPaymentMethodsUseCase;
import com.silog.silog_user.interfaces.rest.paymentmethod.dto.PaymentMethodRequest;
import com.silog.silog_user.interfaces.rest.paymentmethod.dto.PaymentMethodResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    private final CreatePaymentMethodUseCase createPaymentMethodUseCase;
    private final GetPaymentMethodsUseCase getPaymentMethodsUseCase;
    private final GetPaymentMethodByIdUseCase getPaymentMethodByIdUseCase;

    public PaymentMethodController(CreatePaymentMethodUseCase createPaymentMethodUseCase,
                                   GetPaymentMethodsUseCase getPaymentMethodsUseCase,
                                   GetPaymentMethodByIdUseCase getPaymentMethodByIdUseCase) {
        this.createPaymentMethodUseCase = createPaymentMethodUseCase;
        this.getPaymentMethodsUseCase = getPaymentMethodsUseCase;
        this.getPaymentMethodByIdUseCase = getPaymentMethodByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethodResponse>> getAll() {
        List<PaymentMethod> methods = getPaymentMethodsUseCase.getAll();
        return ResponseEntity.ok(methods.stream().map(PaymentMethodResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodResponse> getById(@PathVariable UUID id) {
        PaymentMethod pm = getPaymentMethodByIdUseCase.getById(id);
        return ResponseEntity.ok(PaymentMethodResponse.fromDomain(pm));
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    @PostMapping
    public ResponseEntity<PaymentMethodResponse> create(@Valid @RequestBody PaymentMethodRequest request) {
        PaymentMethod created = createPaymentMethodUseCase.create(request.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(PaymentMethodResponse.fromDomain(created));
    }
}
