package com.silog.silog_user.domain.port.in.SaleDetail;

import com.silog.silog_user.domain.model.SaleDetail;

import java.util.UUID;

public interface GetSaleDetailByIdUseCase {
    SaleDetail getSaleDetailById(UUID id);
}
