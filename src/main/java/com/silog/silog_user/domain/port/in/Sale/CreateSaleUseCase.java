package com.silog.silog_user.domain.port.in.Sale;

import com.silog.silog_user.domain.model.Sale;

public interface CreateSaleUseCase {
    Sale create(Sale sale);
}
