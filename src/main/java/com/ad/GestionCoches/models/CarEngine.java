package com.ad.GestionCoches.models;

import jakarta.persistence.*;

@Entity
@Table(name = "car_engine")
public class CarEngine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fuelType;
    @Column(nullable = false)
    private String drivetrain;
    @Column(nullable = false, unique = true)
    private String engineCode;
    @Column(nullable = false)
    private Integer engineTorque;
    @Column(nullable = false)
    private Integer engineDisplacement;
    @Column(nullable = false)
    private Integer cylinderNumber;
    @Column(nullable = false)
    private String injectionSystem;
    @Column(nullable = false)
    private String engineAspiration;
    @Column(nullable = false)
    private Integer maximumSpeed;
    @Column(nullable = false)
    private Double acceleration;

    public CarEngine() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }

    public Integer getEngineTorque() {
        return engineTorque;
    }

    public void setEngineTorque(Integer engineTorque) {
        this.engineTorque = engineTorque;
    }

    public Integer getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(Integer engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public Integer getCylinderNumber() {
        return cylinderNumber;
    }

    public void setCylinderNumber(Integer cylinderNumber) {
        this.cylinderNumber = cylinderNumber;
    }

    public String getInjectionSystem() {
        return injectionSystem;
    }

    public void setInjectionSystem(String injectionSystem) {
        this.injectionSystem = injectionSystem;
    }

    public String getEngineAspiration() {
        return engineAspiration;
    }

    public void setEngineAspiration(String engineAspiration) {
        this.engineAspiration = engineAspiration;
    }

    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(Integer maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }
}