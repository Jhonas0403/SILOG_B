package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.CashSession;
import com.silog.silog_user.domain.model.CashSessionOpeningAmount;
import com.silog.silog_user.infrastructure.entity.CashSessionEntity;
import com.silog.silog_user.infrastructure.entity.CashSessionOpeningAmountEntity;

public class CashSessionMapper {

    public static CashSessionEntity toEntity(CashSession session) {
        CashSessionEntity entity = new CashSessionEntity();
        entity.setId(session.getId());
        entity.setStoreId(session.getStoreId());
        entity.setOpenedBy(session.getOpenedBy());
        entity.setClosedBy(session.getClosedBy());
        entity.setOpenedAt(session.getOpenedAt());
        entity.setClosedAt(session.getClosedAt());
        entity.setStatus(session.getStatus());
        entity.setNotes(session.getNotes());
        return entity;
    }

    public static CashSession toDomain(CashSessionEntity entity) {
        if (entity == null) return null;
        CashSession session = new CashSession();
        session.setId(entity.getId());
        session.setStoreId(entity.getStoreId());
        session.setOpenedBy(entity.getOpenedBy());
        session.setClosedBy(entity.getClosedBy());
        session.setOpenedAt(entity.getOpenedAt());
        session.setClosedAt(entity.getClosedAt());
        session.setStatus(entity.getStatus());
        session.setNotes(entity.getNotes());
        session.setCreatedAt(entity.getCreatedAt());
        session.setUpdatedAt(entity.getUpdatedAt());
        return session;
    }

    public static CashSessionOpeningAmountEntity toAmountEntity(CashSessionOpeningAmount amount) {
        CashSessionOpeningAmountEntity entity = new CashSessionOpeningAmountEntity();
        entity.setId(amount.getId());
        entity.setCashSessionId(amount.getCashSessionId());
        entity.setPaymentMethodId(amount.getPaymentMethodId());
        entity.setAmount(amount.getAmount());
        return entity;
    }

    public static CashSessionOpeningAmount toAmountDomain(CashSessionOpeningAmountEntity entity) {
        if (entity == null) return null;
        CashSessionOpeningAmount amount = new CashSessionOpeningAmount();
        amount.setId(entity.getId());
        amount.setCashSessionId(entity.getCashSessionId());
        amount.setPaymentMethodId(entity.getPaymentMethodId());
        amount.setAmount(entity.getAmount());
        return amount;
    }
}
