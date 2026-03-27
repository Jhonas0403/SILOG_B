package com.silog.silog_user.application.service.Subcategory;

import com.silog.silog_user.domain.model.Subcategory;
import com.silog.silog_user.domain.port.in.Subcategory.CreateSubcategoryUseCase;
import com.silog.silog_user.domain.port.out.SubcategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateSubcategoryService implements CreateSubcategoryUseCase {
    public final SubcategoryRepositoryPort subcategoryRepositoryPort;

    public CreateSubcategoryService(SubcategoryRepositoryPort subcategoryRepositoryPort) {
        this.subcategoryRepositoryPort = subcategoryRepositoryPort;
    }
    @Override
    public Subcategory create(Subcategory subcategory) {
        Integer nextOrder = subcategoryRepositoryPort.findMaxOrder() + 1;
        if(subcategory.getStatus() == null){
            subcategory.setStatus(true);
        }
        if(subcategory.getUpdatedBy() == null) {
            subcategory.setUpdatedBy(subcategory.getCreatedBy());
        }
        subcategory.setCreatedAt(LocalDateTime.now());
        subcategory.setUpdatedAt(LocalDateTime.now());
        subcategory.setOrder(nextOrder);
        return subcategoryRepositoryPort.save(subcategory);
    }
}
