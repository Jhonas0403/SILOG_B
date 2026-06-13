package com.silog.silog_user.application.service.Company;

import com.silog.silog_user.domain.model.Company;
import com.silog.silog_user.domain.port.in.Company.GetCompaniesUseCase;
import com.silog.silog_user.domain.port.out.CompanyRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCompaniesService implements GetCompaniesUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    public GetCompaniesService(CompanyRepositoryPort companyRepositoryPort) {
        this.companyRepositoryPort = companyRepositoryPort;
    }

    @Override
    public List<Company> getAll() {
        return companyRepositoryPort.findAll();
    }
}
