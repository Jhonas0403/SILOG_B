package com.silog.silog_user.application.service.Store;

import com.silog.silog_user.domain.exception.ResourceNotFoundException;
import com.silog.silog_user.domain.model.Store;
import com.silog.silog_user.domain.port.in.Store.CreateStoreUseCase;
import com.silog.silog_user.domain.port.out.CompanyRepositoryPort;
import com.silog.silog_user.domain.port.out.StoreRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateStoreService implements CreateStoreUseCase {

    private final StoreRepositoryPort storeRepositoryPort;
    private final CompanyRepositoryPort companyRepositoryPort;

    public CreateStoreService(StoreRepositoryPort storeRepositoryPort,
                              CompanyRepositoryPort companyRepositoryPort) {
        this.storeRepositoryPort = storeRepositoryPort;
        this.companyRepositoryPort = companyRepositoryPort;
    }

    @Override
    public Store create(Store store) {
        if (store.getCompanyId() == null) {
            throw new IllegalArgumentException("La tienda debe pertenecer a una empresa");
        }
        companyRepositoryPort.findById(store.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));
        if (store.getStatus() == null) {
            store.setStatus(true);
        }
        return storeRepositoryPort.save(store);
    }
}
