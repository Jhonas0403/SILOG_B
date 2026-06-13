package com.silog.silog_user.application.service.Company;

import com.silog.silog_user.domain.model.Company;
import com.silog.silog_user.domain.port.in.Company.CreateCompanyUseCase;
import com.silog.silog_user.domain.port.out.CompanyRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyService implements CreateCompanyUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    public CreateCompanyService(CompanyRepositoryPort companyRepositoryPort) {
        this.companyRepositoryPort = companyRepositoryPort;
    }

    @Override
    public Company create(Company company) {
        if (company.getStatus() == null) {
            company.setStatus(true);
        }
        return companyRepositoryPort.save(company);
    }
}
