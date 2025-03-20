package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

public class CarServiceDetailDTO {

    @Schema(description = "ID único del servicio", example = "1")
    private Long id;

    @Schema(description = "Nombre del servicio", example = "Cambio de aceite")
    private String name;

    @Schema(description = "Descripción detallada del servicio", example = "Cambio de aceite para motor de 4 cilindros")
    private String description;

    @Schema(description = "Precio del servicio", example = "99.99")
    private Double price;

    @Schema(description = "Fecha de inicio del servicio", example = "2025-02-27")
    private LocalDate startDate;

    @Schema(description = "Fecha de finalización del servicio", example = "2025-03-05")
    private LocalDate endDate;

    public CarServiceDetailDTO(CarService carService) {
        this.id = carService.getServiceDetail().getId();
        this.name = carService.getServiceDetail().getName();
        this.description = carService.getServiceDetail().getDescription();
        this.price = carService.getServiceDetail().getPrice();
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

    @Override
    public String toString() {
        return "CarServiceDetailDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
