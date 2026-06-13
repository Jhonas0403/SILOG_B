package com.silog.silog_user.application.service.Store;

import com.silog.silog_user.domain.exception.ResourceNotFoundException;
import com.silog.silog_user.domain.model.Store;
import com.silog.silog_user.domain.port.in.Store.GetStoreByIdUseCase;
import com.silog.silog_user.domain.port.out.StoreRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetStoreByIdService implements GetStoreByIdUseCase {

    private final StoreRepositoryPort storeRepositoryPort;

    public GetStoreByIdService(StoreRepositoryPort storeRepositoryPort) {
        this.storeRepositoryPort = storeRepositoryPort;
    }

    @Override
    public Store getById(UUID id) {
        return storeRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tienda no encontrada"));
    }
}
