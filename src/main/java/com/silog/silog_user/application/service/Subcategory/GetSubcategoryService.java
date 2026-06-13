package com.silog.silog_user.application.service.Subcategory;

import com.silog.silog_user.domain.model.Subcategory;
import com.silog.silog_user.domain.port.in.Subcategory.GetSubcategoryUseCase;
import com.silog.silog_user.domain.port.out.SubcategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetSubcategoryService  implements GetSubcategoryUseCase {

    public final SubcategoryRepositoryPort subcategoryRepository;

    public GetSubcategoryService(SubcategoryRepositoryPort subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public List<Subcategory> getSubcategories(UUID storeId) {
        if (storeId != null) return subcategoryRepository.findByStoreId(storeId);
        return subcategoryRepository.findAll();
    }

}
