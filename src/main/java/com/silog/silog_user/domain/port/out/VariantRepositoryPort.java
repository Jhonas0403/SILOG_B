package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Variant;

import java.util.List;
import java.util.UUID;

public interface VariantRepositoryPort {

    List<Variant> findAll();
    Variant save(Variant variant);
    Variant findById(UUID id);

    Integer findMaxOrder();
}
