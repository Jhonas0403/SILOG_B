package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Sale;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface SaleRepositoryPort {
    Sale save(Sale sale);
    List<Sale> findAll();
    Sale findById(UUID id);
    List<Sale> findByStoreId(UUID storeId);
    Map<UUID, BigDecimal> sumTotalByPaymentMethodForStore(UUID storeId, ZonedDateTime from, ZonedDateTime to);
}
