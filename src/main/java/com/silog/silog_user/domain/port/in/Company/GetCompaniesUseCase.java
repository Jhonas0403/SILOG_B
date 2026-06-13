package com.silog.silog_user.domain.port.in.Company;

import com.silog.silog_user.domain.model.Company;

import java.util.List;

public interface GetCompaniesUseCase {
    List<Company> getAll();
}
