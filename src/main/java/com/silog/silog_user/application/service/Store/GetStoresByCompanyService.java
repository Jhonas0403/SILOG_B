package com.silog.silog_user.application.service.Store;

import com.silog.silog_user.domain.model.Store;
import com.silog.silog_user.domain.port.in.Store.GetStoresByCompanyUseCase;
import com.silog.silog_user.domain.port.out.StoreRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetStoresByCompanyService implements GetStoresByCompanyUseCase {

    private final StoreRepositoryPort storeRepositoryPort;

    public GetStoresByCompanyService(StoreRepositoryPort storeRepositoryPort) {
        this.storeRepositoryPort = storeRepositoryPort;
    }

    @Override
    public List<Store> getByCompany(UUID companyId) {
        return storeRepositoryPort.findByCompanyId(companyId);
    }
}
