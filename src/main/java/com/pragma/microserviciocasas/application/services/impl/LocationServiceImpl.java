package com.pragma.microserviciocasas.application.services.impl;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.LocationResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;
import com.pragma.microserviciocasas.application.mappers.LocationDtoMapper;
import com.pragma.microserviciocasas.application.services.LocationService;
import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import com.pragma.microserviciocasas.domain.ports.in.LocationServicePort;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationServicePort locationServicePort;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    public SaveLocationResponse saveLocation(SaveLocationRequest request) {
        locationServicePort.saveLocation(locationDtoMapper.requestToModel(request));
        return new SaveLocationResponse(Constants.SAVE_LOCATION_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PageResult<LocationResponse> searchLocations(String text, Integer page, Integer size, boolean orderAsc) {
        return locationDtoMapper.modelListToResponseList(locationServicePort.searchLocations(text, page, size, orderAsc));
    }

}
