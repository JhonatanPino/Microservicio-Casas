package com.pragma.microserviciocasas.category.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.category.domain.models.CategoryModel;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;
import com.pragma.microserviciocasas.category.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.category.infrastructure.entities.CategoryEntity;
import com.pragma.microserviciocasas.category.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.microserviciocasas.category.infrastructure.repositories.mysql.CategoryRepository;
import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }

    @Override
    public PageResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        Page<CategoryEntity> categories = categoryRepository.findAll(pagination);
        List<CategoryModel> categoryModels = categoryEntityMapper.entityListToModelList(categories.getContent());
        return new PageResult<>( categoryModels,
                                                    categories.getNumber(),
                                                    categories.getSize(),
                                                    orderAsc,
                                                    categories.getTotalElements(),
                                                    categories.getTotalPages()
        );
    }
}
