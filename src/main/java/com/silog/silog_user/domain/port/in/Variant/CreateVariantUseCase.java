package com.silog.silog_user.domain.port.in.Variant;

import com.silog.silog_user.domain.model.Variant;

public interface CreateVariantUseCase {
    Variant create(Variant variant);
}
