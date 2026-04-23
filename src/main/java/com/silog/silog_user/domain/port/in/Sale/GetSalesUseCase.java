package com.silog.silog_user.domain.port.in.Sale;

import com.silog.silog_user.domain.model.Sale;

import java.util.List;

public interface GetSalesUseCase {
    List<Sale> getSales();
}
