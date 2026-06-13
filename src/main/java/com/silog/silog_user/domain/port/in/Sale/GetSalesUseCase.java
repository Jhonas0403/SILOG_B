package com.silog.silog_user.domain.port.in.Sale;

import com.silog.silog_user.domain.model.Sale;

import java.util.List;
import java.util.UUID;

public interface GetSalesUseCase {
    List<Sale> getSales(UUID storeId);
}
