package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Company;
import com.silog.silog_user.domain.port.out.CompanyRepositoryPort;
import com.silog.silog_user.infrastructure.mapper.CompanyMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaCompanyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CompanyRepositoryAdapter implements CompanyRepositoryPort {

    private final JpaCompanyRepository jpaCompanyRepository;

    public CompanyRepositoryAdapter(JpaCompanyRepository jpaCompanyRepository) {
        this.jpaCompanyRepository = jpaCompanyRepository;
    }

    @Override
    public Company save(Company company) {
        return CompanyMapper.toDomain(jpaCompanyRepository.save(CompanyMapper.toEntity(company)));
    }

    @Override
    public List<Company> findAll() {
        return jpaCompanyRepository.findAll().stream().map(CompanyMapper::toDomain).toList();
    }

    @Override
    public Optional<Company> findById(UUID id) {
        return jpaCompanyRepository.findById(id).map(CompanyMapper::toDomain);
    }
}
