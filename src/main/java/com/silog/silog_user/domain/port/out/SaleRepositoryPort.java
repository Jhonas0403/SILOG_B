package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Sale;

import java.util.List;
import java.util.UUID;

public interface SaleRepositoryPort {
    Sale save(Sale sale);
    List<Sale> findAll();
    Sale findById(UUID id);
}
