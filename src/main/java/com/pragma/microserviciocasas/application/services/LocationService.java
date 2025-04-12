package com.pragma.microserviciocasas.application.services;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;

public interface LocationService {
    SaveLocationResponse saveLocation(SaveLocationRequest request);
}
