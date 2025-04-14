package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface LocationPersistencePort {

    boolean existsBySectorAndCityId(String sector, Long idCity);

    void saveLocation(LocationModel locationModel);

    PageResult<LocationModel> searchLocations(String text, Integer page, Integer size, boolean orderAsc);

}
