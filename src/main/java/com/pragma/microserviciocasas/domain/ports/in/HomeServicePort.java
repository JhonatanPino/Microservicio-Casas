package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.models.HomeModel;

public interface HomeServicePort {

    void publishHome(HomeModel homeModel);

}
