package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.SaleDetail;

import java.util.List;
import java.util.UUID;

public interface SaleDetailRepositoryPort {
    SaleDetail save(SaleDetail saleDetail);
    List<SaleDetail> findAll();
    SaleDetail findById(UUID id);
}
