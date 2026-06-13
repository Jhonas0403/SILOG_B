package com.silog.silog_user.domain.port.in.CashSession;

import com.silog.silog_user.domain.model.CashSession;

import java.util.UUID;

public interface GetCurrentCashSessionUseCase {
    CashSession getCurrent(UUID storeId);
}
