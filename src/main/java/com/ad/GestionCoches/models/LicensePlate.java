package com.ad.GestionCoches.models;

import jakarta.persistence.*;

@Entity
@Table(name = "license_plates")
public class LicensePlate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "plate_number")
    private String plateNumber;
    @Column(name = "car_id")
    private Integer carId;
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
