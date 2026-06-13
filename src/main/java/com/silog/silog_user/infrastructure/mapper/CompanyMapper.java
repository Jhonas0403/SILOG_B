package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Company;
import com.silog.silog_user.infrastructure.entity.CompanyEntity;

public class CompanyMapper {

    public static CompanyEntity toEntity(Company company) {
        CompanyEntity entity = new CompanyEntity();
        entity.setId(company.getId());
        entity.setName(company.getName());
        entity.setRuc(company.getRuc());
        entity.setAddress(company.getAddress());
        entity.setPhone(company.getPhone());
        entity.setDescription(company.getDescription());
        entity.setStatus(company.getStatus());
        return entity;
    }

    public static Company toDomain(CompanyEntity e) {
        if (e == null) return null;
        Company company = new Company();
        company.setId(e.getId());
        company.setName(e.getName());
        company.setRuc(e.getRuc());
        company.setAddress(e.getAddress());
        company.setPhone(e.getPhone());
        company.setDescription(e.getDescription());
        company.setStatus(e.getStatus());
        company.setCreatedAt(e.getCreatedAt());
        company.setUpdatedAt(e.getUpdatedAt());
        return company;
    }
}
