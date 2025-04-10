package com.pragma.microserviciocasas.application.services.impl;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;
import com.pragma.microserviciocasas.application.mappers.LocationDtoMapper;
import com.pragma.microserviciocasas.application.services.LocationService;
import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import com.pragma.microserviciocasas.domain.ports.in.LocationServicePort;
import com.pragma.microserviciocasas.infrastructure.entities.CityEntity;
import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.CityRepository;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationServicePort locationServicePort;
    private final LocationRepository locationRepository;
    private final CityRepository cityRepository;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    public SaveLocationResponse saveLocation(SaveLocationRequest request) {

        Optional<CityEntity> city = cityRepository.findById(request.getIdCity());
                if (city.isEmpty()) {
                    throw new EntityNotFoundException("City not found with id: " + request.getIdCity());
                }

        LocationEntity location = locationDtoMapper.requestToEntity(request);
        location.setCity(city.get());

        LocationEntity savedLocation = locationRepository.save(location);
        return new SaveLocationResponse(Constants.SAVE_LOCATION_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    /*@Override
    public SaveLocationResponse saveLocation(SaveLocationRequest request) {
        locationServicePort.saveLocation(locationDtoMapper.requestToModel(request));  //
        return new SaveLocationResponse(Constants.SAVE_LOCATION_RESPONSE_MESSAGE, LocalDateTime.now());
    }*/
}

/*
Conversión de DTO a Entidad: La línea LocationEntity location = locationDtoMapper.requestToEntity(request); utiliza un
 mapper (locationDtoMapper) para convertir el objeto SaveLocationRequest (que es un DTO) en una entidad de base de
  datos (LocationEntity). Esto es necesario porque los DTOs se utilizan para transferir datos entre capas, mientras que las
   entidades representan los datos en la base de datos.
Asignación de la Ciudad: La línea location.setCity(city.get()); asigna la entidad de la ciudad (CityEntity) obtenida previamente
 al objeto LocationEntity. Esto establece la relación entre la ubicación y la ciudad correspondiente.
 */