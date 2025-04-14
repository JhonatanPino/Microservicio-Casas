package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface LocationServicePort {

    void saveLocation(LocationModel locationModel);

    PageResult <LocationModel> searchLocations(String text, Integer page, Integer size, boolean orderAsc);
}
