package com.pragma.microserviciocasas.application.services;

import com.pragma.microserviciocasas.application.dto.request.PublishHomeRequest;
import com.pragma.microserviciocasas.application.dto.response.HomeResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveHomeResponse;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface HomeService {

    SaveHomeResponse publisHome(PublishHomeRequest request);

    PageResult<HomeResponse> searchHomes(String text, Integer page, Integer size, boolean orderAsc);
}
