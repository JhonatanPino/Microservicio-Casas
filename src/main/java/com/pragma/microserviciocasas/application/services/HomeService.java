package com.pragma.microserviciocasas.application.services;

import com.pragma.microserviciocasas.application.dto.request.PublishHomeRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveHomeResponse;

public interface HomeService {

    SaveHomeResponse publisHome(PublishHomeRequest request);


}
