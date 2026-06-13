package com.silog.silog_user.application.service.Store;

import com.silog.silog_user.domain.model.Store;
import com.silog.silog_user.domain.port.in.Store.GetStoresUseCase;
import com.silog.silog_user.domain.port.out.StoreRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStoresService implements GetStoresUseCase {

    private final StoreRepositoryPort storeRepositoryPort;

    public GetStoresService(StoreRepositoryPort storeRepositoryPort) {
        this.storeRepositoryPort = storeRepositoryPort;
    }

    @Override
    public List<Store> getAll() {
        return storeRepositoryPort.findAll();
    }
}
