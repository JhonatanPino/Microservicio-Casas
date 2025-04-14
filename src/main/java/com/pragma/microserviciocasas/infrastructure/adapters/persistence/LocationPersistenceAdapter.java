package com.pragma.microserviciocasas.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.ports.out.LocationPersistencePort;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import com.pragma.microserviciocasas.infrastructure.mappers.LocationEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {
    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public void saveLocation(LocationModel locationModel) {
        locationRepository.save(locationEntityMapper.modelToEntity(locationModel));
    }

    @Override
    public boolean existsBySectorAndCityId(String sector, Long idCity) {
        return locationRepository.existsBySectorAndCity_Id(sector, idCity);
    }

    @Override
    public PageResult<LocationModel> searchLocations(String text, Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;

        if (orderAsc){
            pagination = PageRequest.of(page, size, Sort.by( Constants.PAGEABLE_FIELD_NAME_DEPARTMENT,
                            Constants.PAGEABLE_FIELD_NAME_CITY,
                            Constants.PAGEABLE_FIELD_NAME_SECTOR)
                            .ascending());
        }
        else{
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME_DEPARTMENT,
                            Constants.PAGEABLE_FIELD_NAME_CITY,
                            Constants.PAGEABLE_FIELD_NAME_SECTOR)
                            .descending());
        }
        Page<LocationEntity> locations = locationRepository.findByCityOrDepartmentName(text, pagination);
        List<LocationModel> locationModels = locationEntityMapper.entityListToModelList(locations.getContent());

        return new PageResult<>(
                locationModels,
                locations.getNumber(),
                locations.getSize(),
                orderAsc,
                locations.getTotalElements(),
                locations.getTotalPages()
        );
    }

}
