package com.silog.silog_user.domain.port.in.CashSession;

import com.silog.silog_user.domain.model.CashSessionReport;

import java.util.UUID;

public interface CloseCashSessionUseCase {
    CashSessionReport close(UUID storeId, UUID closedBy, String notes);
}
