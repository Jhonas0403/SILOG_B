package com.silog.silog_user.domain.port.in.CashSession;

import com.silog.silog_user.domain.model.CashSession;
import com.silog.silog_user.domain.model.CashSessionOpeningAmount;

import java.util.List;

public interface OpenCashSessionUseCase {
    CashSession open(CashSession session, List<CashSessionOpeningAmount> openingAmounts);
}
