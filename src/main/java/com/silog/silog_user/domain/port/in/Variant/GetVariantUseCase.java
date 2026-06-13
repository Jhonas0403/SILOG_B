package com.silog.silog_user.domain.port.in.Variant;

import com.silog.silog_user.domain.model.Variant;

import java.util.List;
import java.util.UUID;

public interface GetVariantUseCase {
    List<Variant> getVariants(UUID storeId);
}
