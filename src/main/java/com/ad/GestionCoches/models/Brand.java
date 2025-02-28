package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brands")
    @NotNull
    @Schema(description = "Id único de la marca", example = "1")
    private Long id;

    @Column
    @NotNull
    @Schema(description = "Nombre de la marca", example = "Toyota")
    private String name;

    @Column
    @NotNull
    @Schema(description = "País de origen de la marca", example = "Japón")
    private String country;

    public Brand() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
