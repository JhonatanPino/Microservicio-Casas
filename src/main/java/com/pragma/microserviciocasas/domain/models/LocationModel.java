package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.LocationSectorMaxSizeExceededException;

import java.util.Objects;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.LOCATION_FIELD_CITY_NULL_MESSAGE;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.LOCATION_FIELD_SECTOR_NULL_MESSAGE;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.LOCATION_FIELD_SECTOR_MAX_SIZE;

public class LocationModel {
    private Long id;
    private String sector;
    private CityModel city;

    public LocationModel(Long id, String sector, CityModel city) {
        if(sector.length() > LOCATION_FIELD_SECTOR_MAX_SIZE){
            throw new LocationSectorMaxSizeExceededException();
        }
        if (sector.isBlank()){
            throw new EmptyFieldException();
        }

        this.id = id;
        this.sector = Objects.requireNonNull(sector, LOCATION_FIELD_SECTOR_NULL_MESSAGE);
        this.city = Objects.requireNonNull(city, LOCATION_FIELD_CITY_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getSector() {
        return sector;
    }

    public CityModel getCity() {
        return city;
    }

    public void setSector(String sector) {
        if(sector.length() > LOCATION_FIELD_SECTOR_MAX_SIZE){
            throw new LocationSectorMaxSizeExceededException();
        }
        if (sector.isBlank()){
            throw new EmptyFieldException();
        }
        this.sector = Objects.requireNonNull(sector, LOCATION_FIELD_SECTOR_NULL_MESSAGE);
    }

    public void setCity(CityModel city) {
        this.city = Objects.requireNonNull(city, LOCATION_FIELD_CITY_NULL_MESSAGE);
    }
}