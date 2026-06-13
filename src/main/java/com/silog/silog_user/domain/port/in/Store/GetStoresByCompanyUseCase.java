package com.silog.silog_user.domain.port.in.Store;

import com.silog.silog_user.domain.model.Store;

import java.util.List;
import java.util.UUID;

public interface GetStoresByCompanyUseCase {
    List<Store> getByCompany(UUID companyId);
}
