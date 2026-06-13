package com.silog.silog_user.domain.port.in.Company;

import com.silog.silog_user.domain.model.Company;

public interface CreateCompanyUseCase {
    Company create(Company company);
}
