package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepositoryPort {
    Company save(Company company);
    List<Company> findAll();
    Optional<Company> findById(UUID id);
}
