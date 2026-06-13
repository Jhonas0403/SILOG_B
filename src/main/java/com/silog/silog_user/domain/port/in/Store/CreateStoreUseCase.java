package com.silog.silog_user.domain.port.in.Store;

import com.silog.silog_user.domain.model.Store;

public interface CreateStoreUseCase {
    Store create(Store store);
}
