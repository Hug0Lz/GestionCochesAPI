package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class ServiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del servicio", example = "1")
    private Long id;

    @Column(nullable = false, unique = true)
    @Schema(description = "Nombre del servicio", example = "Garantía extendida")
    private String name;

    @Column
    @Schema(description = "Descripción del servicio", example = "Garantía extendida de dos años para piezas con fallos de fábrica")
    private String description;

    @Column(nullable = false)
    @Schema(description = "Precio del servicio", example = "99.99")
    private Double price;

    public ServiceDetail() {
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
}
