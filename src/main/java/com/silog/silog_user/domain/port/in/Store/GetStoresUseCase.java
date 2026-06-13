package com.silog.silog_user.domain.port.in.Store;

import com.silog.silog_user.domain.model.Store;

import java.util.List;

public interface GetStoresUseCase {
    List<Store> getAll();
}
