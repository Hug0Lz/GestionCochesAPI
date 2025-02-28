package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "car_details")
public class CarDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del detalle del coche", example = "1")
    private Long id;

    @Column(nullable = false, unique = true, length = 17)
    @NotNull
    @Schema(description = "Número de Identificación del Vehículo (VIN)", example = "1HGBH41JXMN109186")
    private String vin;

    @Column
    @Schema(description = "Color del coche", example = "Rojo")
    private String color;

    @Column
    @Schema(description = "Extras del coche", example = "Navegador, Asientos de cuero")
    private String extras;

    @ManyToOne
    @JoinColumn(name = "car_model_id", nullable = false)
    @Schema(description = "Modelo del coche asociado", example = "Audi A4 2023")
    private CarModel carModel;

    @ManyToOne
    @JoinColumn(name = "engine_id", nullable = false)
    @Schema(description = "Motor del coche asociado", example = "Motor 2.0 TDI")
    private CarEngine engine;

    @OneToMany(mappedBy = "carDetail")
    @Schema(description = "Lista de servicios asociados a este coche")
    private List<CarService> carServices;

    public CarDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarEngine getEngine() {
        return engine;
    }

    public void setEngine(CarEngine engine) {
        this.engine = engine;
    }

    public List<CarService> getCarServices() {
        return carServices;
    }

    public void setCarServices(List<CarService> carServices) {
        this.carServices = carServices;
    }
}
