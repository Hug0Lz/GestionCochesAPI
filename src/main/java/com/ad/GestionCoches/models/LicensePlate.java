package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "license_plates")
public class LicensePlate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la placa de matrícula", example = "1")
    private Long id;

    @Column(name = "plate_number")
    @Schema(description = "Número de la placa de matrícula", example = "ABC1234")
    private String plateNumber;

    @Column(name = "car_id")
    @Schema(description = "ID del coche al que pertenece la matrícula", example = "101")
    private Integer carId;

    @Column
    @Schema(description = "Provincia de la matrícula (por ejemplo, 'Madrid', 'Barcelona')", example = "Madrid")
    private String state;

    public LicensePlate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
