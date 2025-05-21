package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface HomeServicePort {

    void publishHome(HomeModel homeModel);

    PageResult<HomeModel> searchHomes(String text, Integer page, Integer size, boolean orderAsc);
}
