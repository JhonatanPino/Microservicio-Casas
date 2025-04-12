package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.models.CityModel;
import com.pragma.microserviciocasas.domain.models.LocationModel;

public interface LocationPersistencePort {

    boolean existsBySectorAndCityId(String sector, Long idCity);

    void saveLocation(LocationModel locationModel);

    //LocationModel getLocationById(Long id);
}
