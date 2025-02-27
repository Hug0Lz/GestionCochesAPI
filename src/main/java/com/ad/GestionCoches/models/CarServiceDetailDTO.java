package com.ad.GestionCoches.models;

import java.time.LocalDate;

public class CarServiceDetailDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;


    public CarServiceDetailDTO(CarService carService) {
        this.id = carService.getService().getId();
        this.name = carService.getService().getName();
        this.description = carService.getService().getDescription();
        this.price = carService.getService().getPrice();
        this.startDate = carService.getStartDate();
        this.endDate = carService.getEndDate();
    }

    public CarServiceDetailDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
