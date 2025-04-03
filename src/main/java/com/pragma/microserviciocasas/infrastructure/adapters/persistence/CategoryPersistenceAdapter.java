package com.pragma.microserviciocasas.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.domain.models.CategoryModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.infrastructure.entities.CategoryEntity;
import com.pragma.microserviciocasas.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.CategoryRepository;
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
    public void saveCategory(CategoryModel categoryModel) {
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

/*
La clase CategoryPersistenceAdapter es un adaptador de persistencia en una aplicación Spring Boot. Implementa la interfaz
 CategoryPersistencePort y proporciona la lógica para interactuar con la base de datos. A continuación, se detallan sus componentes:
Anotaciones:
@Service: Indica que esta clase es un componente de servicio de Spring.
@Transactional: Indica que los métodos de esta clase deben ejecutarse dentro de una transacción.
@RequiredArgsConstructor: Genera un constructor con los argumentos obligatorios (campos finales).
Campos:
CategoryRepository categoryRepository: Un repositorio de Spring Data JPA para realizar operaciones CRUD en la entidad CategoryEntity.
CategoryEntityMapper categoryEntityMapper: Un mapeador para convertir entre CategoryModel y CategoryEntity.
Métodos:
saveCategory(CategoryModel categoryModel): Guarda una categoría en la base de datos convirtiendo el CategoryModel a CategoryEntity
 y utilizando el repositorio.
getCategoryByName(String categoryName): Recupera una categoría por su nombre, convirtiendo la CategoryEntity
 resultante a CategoryModel.
getCategories(Integer page, Integer size, boolean orderAsc): Recupera una lista paginada de categorías, ordenada ascendente
 o descendentemente según el parámetro orderAsc. Convierte la lista de CategoryEntity a CategoryModel y devuelve un PageResult.
 */