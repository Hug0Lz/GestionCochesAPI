package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "car_models")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_models")
    @Schema(description = "ID único del modelo de coche", example = "1")
    private Long id;

    @Column
    @NotNull
    @Schema(description = "Modelo del coche", example = "A4")
    private String model;

    @Column
    @Schema(description = "Generación del modelo de coche", example = "B9")
    private String generation;

    @Column
    @NotNull
    @Schema(description = "Año de fabricación del modelo de coche", example = "2023")
    private Integer year;

    @Column
    @NotNull
    @Schema(description = "Segmento del coche (A, B, C, D, E, F, J, M, S)", example = "D")
    private Segment segment;

    @Column
    @NotNull
    @Schema(description = "Precio del coche", example = "45000.00")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @Schema(description = "Marca del coche", example = "Audi")
    private Brand brand;

    @Column
    @Schema(description = "Dirección de la imagen del coche", example = "img/audi-a4")
    private String image;

    public CarModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
