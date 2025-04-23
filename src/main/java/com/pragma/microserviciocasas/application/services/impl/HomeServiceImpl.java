package com.pragma.microserviciocasas.application.services.impl;

import com.pragma.microserviciocasas.application.dto.request.PublishHomeRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveHomeResponse;
import com.pragma.microserviciocasas.application.mappers.HomeDtoMapper;
import com.pragma.microserviciocasas.application.services.HomeService;
import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import com.pragma.microserviciocasas.domain.ports.in.HomeServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final HomeServicePort homeServicePort;
    private final HomeDtoMapper homeDtoMapper;

    @Override
    public SaveHomeResponse publisHome(PublishHomeRequest request) {
        homeServicePort.publishHome(homeDtoMapper.requestToModel(request));
        return new SaveHomeResponse(Constants.PUBLISH_HOME_RESPONSE_MESSAGE, LocalDateTime.now());
    }

}
