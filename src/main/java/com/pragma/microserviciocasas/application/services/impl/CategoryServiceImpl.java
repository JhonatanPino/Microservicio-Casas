package com.pragma.microserviciocasas.application.services.impl;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.application.mappers.CategoryDtoMapper;
import com.pragma.microserviciocasas.application.services.CategoryService;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import com.pragma.microserviciocasas.domain.ports.in.CategoryServicePort;
import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse saveCategory(SaveCategoryRequest request) {
        categoryServicePort.saveCategory(categoryDtoMapper.requestToModel(request));
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PageResult<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryDtoMapper.modelListToResponseList(categoryServicePort.getCategories(page, size, orderAsc));
    }
}



/*La clase CategoryServiceImpl es una implementación de servicio en una aplicación Spring Boot. Implementa la interfaz CategoryService y proporciona
 la lógica de negocio para gestionar las operaciones relacionadas con categorías. A continuación, se detallan sus componentes:
Anotaciones:
@Service: Indica que esta clase es un componente de servicio de Spring.
@RequiredArgsConstructor: Genera un constructor con los argumentos obligatorios (campos finales).
Campos:
CategoryServicePort categoryServicePort: Una interfaz de puerto para operaciones relacionadas con categorías.
CategoryDtoMapper categoryDtoMapper: Un mapeador para la conversión entre DTO y modelos de dominio.
Métodos:
save(SaveCategoryRequest request): Convierte SaveCategoryRequest en un modelo de dominio mediante el mapeador, llama al método
 save en categoryServicePort y devuelve una SaveCategoryResponse con un mensaje de éxito y una marca de tiempo.
 getCategories(Integer page, Integer size, boolean orderAsc): recupera una lista paginada de categorías de categoryServicePort, convierte
  la lista en DTO CategoryResponse mediante el asignador y devuelve el resultado.
 */