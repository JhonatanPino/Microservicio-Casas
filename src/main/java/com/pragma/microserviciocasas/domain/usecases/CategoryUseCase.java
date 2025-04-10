package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.CategoryAlreadyExistsException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPageOrSizeException;
import com.pragma.microserviciocasas.domain.models.CategoryModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import com.pragma.microserviciocasas.domain.ports.in.CategoryServicePort;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;

public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());

        if (category != null) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.saveCategory(categoryModel);
    }

    @Override
    public PageResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {

        if (page < 0 || size <= 0) {
            throw new InvalidPageOrSizeException();
        }
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }
}



/*
La clase CategoryUseCase es una implementación de la interfaz CategoryServicePort en una aplicación Spring Boot.
 Esta clase contiene la lógica de negocio para gestionar las operaciones relacionadas con las categorías.
  A continuación, se detallan sus componentes:
Campos:
CategoryPersistencePort categoryPersistencePort: Una interfaz de puerto para operaciones de persistencia relacionadas con categorías.
Constructor:
CategoryUseCase(CategoryPersistencePort categoryPersistencePort): Inicializa el campo categoryPersistencePort
 con la implementación proporcionada.
Métodos:
 saveCategory(CategoryModel categoryModel): Este método guarda un modelo de categoría. Primero, verifica si una categoría
 con el mismo nombre ya existe llamando a getCategoryByName en categoryPersistencePort. Si la categoría ya existe,
  lanza una excepción CategoryAlreadyExistsException. Si no, guarda la nueva categoría llamando a saveCategory en categoryPersistencePort.
getCategories(Integer page, Integer size, boolean orderAsc): Este método recupera una lista paginada de categorías
 llamando a getCategories en categoryPersistencePort y devuelve el resultado.

 */