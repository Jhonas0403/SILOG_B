package com.silog.silog_user.domain.port.in.Sale;

import com.silog.silog_user.domain.model.Sale;

import java.util.UUID;

public interface GetSaleByIdUseCase {
    Sale getSaleById(UUID id);
}
