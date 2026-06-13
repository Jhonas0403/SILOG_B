package com.silog.silog_user.domain.port.in.Company;

import com.silog.silog_user.domain.model.Company;

import java.util.UUID;

public interface GetCompanyByIdUseCase {
    Company getById(UUID id);
}
