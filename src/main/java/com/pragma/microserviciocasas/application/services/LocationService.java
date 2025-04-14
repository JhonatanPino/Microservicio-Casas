package com.pragma.microserviciocasas.application.services;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.LocationResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface LocationService {
    SaveLocationResponse saveLocation(SaveLocationRequest request);

    PageResult<LocationResponse> searchLocations(String text, Integer page, Integer size, boolean orderAsc);
}
