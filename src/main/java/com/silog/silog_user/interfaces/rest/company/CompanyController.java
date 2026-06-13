package com.silog.silog_user.interfaces.rest.company;

import com.silog.silog_user.domain.model.Company;
import com.silog.silog_user.domain.port.in.Company.CreateCompanyUseCase;
import com.silog.silog_user.domain.port.in.Company.GetCompaniesUseCase;
import com.silog.silog_user.domain.port.in.Company.GetCompanyByIdUseCase;
import com.silog.silog_user.interfaces.rest.company.dto.CompanyRequest;
import com.silog.silog_user.interfaces.rest.company.dto.CompanyResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class CompanyController {

    private final CreateCompanyUseCase createCompanyUseCase;
    private final GetCompaniesUseCase getCompaniesUseCase;
    private final GetCompanyByIdUseCase getCompanyByIdUseCase;

    public CompanyController(CreateCompanyUseCase createCompanyUseCase,
                             GetCompaniesUseCase getCompaniesUseCase,
                             GetCompanyByIdUseCase getCompanyByIdUseCase) {
        this.createCompanyUseCase = createCompanyUseCase;
        this.getCompaniesUseCase = getCompaniesUseCase;
        this.getCompanyByIdUseCase = getCompanyByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAll() {
        return ResponseEntity.ok(getCompaniesUseCase.getAll()
                .stream().map(CompanyResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(CompanyResponse.fromDomain(getCompanyByIdUseCase.getById(id)));
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> create(@Valid @RequestBody CompanyRequest request) {
        Company created = createCompanyUseCase.create(request.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(CompanyResponse.fromDomain(created));
    }
}
