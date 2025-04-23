package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.models.HomeModel;

public interface HomePersistencePort {

    boolean existsByNameAndLocationId(String name, Long idLocation);

    void publishHome(HomeModel homeModel);


}
