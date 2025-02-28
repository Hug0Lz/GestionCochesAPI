package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "car_engine")
public class CarEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del motor del coche", example = "1")
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Tipo de combustible del motor", example = "Gasolina")
    private String fuelType;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Tracción del vehículo", example = "Tracción delantera")
    private String drivetrain;

    @Column(nullable = false, unique = true)
    @NotNull
    @Schema(description = "Código del motor", example = "ABC123")
    private String engineCode;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Par motor del vehículo", example = "350")
    private Integer engineTorque;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Cilindrada del motor en cm³", example = "2000")
    private Integer engineDisplacement;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Número de cilindros del motor", example = "4")
    private Integer cylinderNumber;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Sistema de inyección del motor", example = "Inyección directa")
    private String injectionSystem;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Tipo de aspiración del motor", example = "Turboalimentado")
    private String engineAspiration;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Velocidad máxima alcanzable por el motor (km/h)", example = "240")
    private Integer maximumSpeed;

    @Column(nullable = false)
    @NotNull
    @Schema(description = "Aceleración 0-100 km/h en segundos", example = "6.5")
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
