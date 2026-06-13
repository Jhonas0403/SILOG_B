package com.silog.silog_user.domain.port.in.SaleDetail;

import com.silog.silog_user.domain.model.SaleDetail;

import java.util.List;
import java.util.UUID;

public interface GetSaleDetailsUseCase {
    List<SaleDetail> getSaleDetails(UUID storeId);
}
