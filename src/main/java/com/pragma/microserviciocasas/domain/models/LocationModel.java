package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;

import java.util.Objects;

public class LocationModel {
    private Long id;
    private String sector;
    private CityModel city;

    public LocationModel(Long id, String sector, CityModel city) {
        if (sector.isEmpty()){
            throw new EmptyFieldException();
        }

        this.id = id;
        this.sector = Objects.requireNonNull(sector, "Sector cannot be null");
        this.city = Objects.requireNonNull(city, "City cannot be null");
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
        if (sector.isEmpty()){
            throw new EmptyFieldException();
        }
        this.sector = Objects.requireNonNull(sector, "Sector cannot be null");
    }
    public void setCity(CityModel city) {
        this.city = Objects.requireNonNull(city, "City cannot be null");
    }
}
// ARREGLAR LAS CONSTANTES