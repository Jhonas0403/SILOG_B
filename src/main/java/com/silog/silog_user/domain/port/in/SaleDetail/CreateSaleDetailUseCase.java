package com.silog.silog_user.domain.port.in.SaleDetail;

import com.silog.silog_user.domain.model.SaleDetail;

public interface CreateSaleDetailUseCase {
    SaleDetail create(SaleDetail saleDetail);
}
