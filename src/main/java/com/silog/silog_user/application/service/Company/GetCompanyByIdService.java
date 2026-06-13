package com.silog.silog_user.application.service.Company;

import com.silog.silog_user.domain.exception.ResourceNotFoundException;
import com.silog.silog_user.domain.model.Company;
import com.silog.silog_user.domain.port.in.Company.GetCompanyByIdUseCase;
import com.silog.silog_user.domain.port.out.CompanyRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetCompanyByIdService implements GetCompanyByIdUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    public GetCompanyByIdService(CompanyRepositoryPort companyRepositoryPort) {
        this.companyRepositoryPort = companyRepositoryPort;
    }

    @Override
    public Company getById(UUID id) {
        return companyRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));
    }
}
