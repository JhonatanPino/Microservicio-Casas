package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface HomePersistencePort {

    boolean existsByNameAndLocationId(String name, Long idLocation);

    void publishHome(HomeModel homeModel);

    void updateStatusToPublishedIfActiveDateReached();

    PageResult<HomeModel> searchHomes(String text, Integer page, Integer size, boolean orderAsc);
}
