package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.utils.constants.DomainConstants;
import com.pragma.microserviciocasas.domain.utils.enumerations.PublicationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static com.pragma.microserviciocasas.domain.utils.validations.DomainValidations.*;

public class HomeModel {
    private Long id;
    private String name;
    private String description;
    private Integer rooms;
    private Integer bathrooms;
    private BigDecimal price;
    private LocalDate publicationDate;
    private LocalDate publicationDateActive;
    private PublicationStatus status;
    private CategoryModel category;
    private LocationModel location;

    public HomeModel(Long id, String name, String description, Integer rooms, Integer bathrooms,
                     BigDecimal price, LocalDate publicationDate, LocalDate publicationDateActive,
                     PublicationStatus status, CategoryModel category, LocationModel location) {

        isNullOrBlankValidationC(id, name, description, rooms, bathrooms, price,
                publicationDate, publicationDateActive, status, category, location);
        isValidNumberValidation(rooms.toString());
        isValidNumberValidation(bathrooms.toString());
        isValidNumberValidation(price.toString());
        isValidPublicationDateActiveValidation(publicationDateActive, publicationDate);


        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.HOME_FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description, DomainConstants.HOME_FIELD_DESCRIPTION_NULL_MESSAGE);
        this.rooms = Objects.requireNonNull(rooms, DomainConstants.HOME_FIELD_ROOMS_NULL_MESSAGE);
        this.bathrooms = Objects.requireNonNull(bathrooms, DomainConstants.HOME_FIELD_BATHROOMS_NULL_MESSAGE);
        this.price = Objects.requireNonNull(price, DomainConstants.HOME_FIELD_PRICE_NULL_MESSAGE);
        this.publicationDate = Objects.requireNonNull(publicationDate, DomainConstants.HOME_FIELD_PUBLICATION_DATE_NULL_MESSAGE);
        this.publicationDateActive = Objects.requireNonNull(publicationDateActive, DomainConstants.HOME_FIELD_PUBLICATION_DATE_ACTIVE_NULL_MESSAGE);
        this.status = Objects.requireNonNull(status, DomainConstants.HOME_FIELD_STATUS_NULL_MESSAGE);
        this.category = Objects.requireNonNull(category, DomainConstants.HOME_FIELD_CATEGORY_NULL_MESSAGE);
        this.location = Objects.requireNonNull(location, DomainConstants.HOME_FIELD_LOCATION_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Integer getRooms() {
        return rooms;
    }
    public Integer getBathrooms() {
        return bathrooms;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public LocalDate getPublicationDateActive() {
        return publicationDateActive;
    }
    public PublicationStatus getStatus() {
        return status;
    }
    public CategoryModel getCategory() {
        return category;
    }
    public LocationModel getLocation() {
        return location;
    }

    public void setId(Long id) {
        isNullOrBlankValidationI(id);
        this.id = id;
    }
    public void setName(String name) {
        isNullOrBlankValidationS(name);
        this.name = Objects.requireNonNull(name, DomainConstants.HOME_FIELD_NAME_NULL_MESSAGE);
    }
    public void setDescription(String description) {
        isNullOrBlankValidationS(description);
        this.description = Objects.requireNonNull(description, DomainConstants.HOME_FIELD_DESCRIPTION_NULL_MESSAGE);
    }
    public void setRooms(Integer rooms) {
        isNullOrBlankValidationS(rooms);
        this.rooms = rooms;
    }
    public void setBathrooms(Integer bathrooms) {
        isNullOrBlankValidationS(bathrooms);
        this.bathrooms = bathrooms;
    }
    public void setPrice(BigDecimal price) {
        isNullOrBlankValidationS(price);
        this.price = price;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        isNullOrBlankValidationS(publicationDate);
        this.publicationDate = publicationDate;
    }
    public void setPublicationDateActive(LocalDate publicationDateActive) {
        isNullOrBlankValidationS(publicationDateActive);
        this.publicationDateActive = publicationDateActive;
    }
    public void setStatus(PublicationStatus status) {
        isNullOrBlankValidationS(status);
        this.status = status;
    }
    public void setCategory(CategoryModel category) {
        isNullOrBlankValidationI(category);
        this.category = category;
    }
    public void setLocation(LocationModel location) {
        isNullOrBlankValidationI(location);
        this.location = location;
    }
}
