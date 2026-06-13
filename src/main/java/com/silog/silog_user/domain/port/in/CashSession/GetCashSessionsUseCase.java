package com.silog.silog_user.domain.port.in.CashSession;

import com.silog.silog_user.domain.model.CashSession;

import java.util.List;
import java.util.UUID;

public interface GetCashSessionsUseCase {
    List<CashSession> getSessions(UUID storeId);
}
