package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

public class CarDetailDTO {

    @Schema(description = "ID único del detalle del coche", example = "1")
    private Long id;

    @Schema(description = "Número de identificación del vehículo (VIN)", example = "1HGCM82633A123456")
    private String vin;

    @Schema(description = "Color del coche", example = "Rojo")
    private String color;

    @Schema(description = "Extras del coche", example = "Climatizador, Asientos de cuero")
    private String extras;

    @Schema(description = "Modelo del coche", implementation = CarModel.class)
    private CarModel carModel;

    @Schema(description = "Motor del coche", implementation = CarEngine.class)
    private CarEngine engine;

    @Schema(description = "Lista de servicios asociados al coche", implementation = CarServiceDetailDTO.class)
    private List<CarServiceDetailDTO> carServices;

    public CarDetailDTO(CarDetail carDetail) {
        this.id = carDetail.getId();
        this.vin = carDetail.getVin();
        this.color = carDetail.getColor();
        this.extras = carDetail.getExtras();
        this.carModel = carDetail.getCarModel();
        this.engine = carDetail.getEngine();
        this.carServices = new ArrayList<>();
        carDetail.getCarServices().forEach(carService -> this.carServices.add(new CarServiceDetailDTO(carService)));
    }

    public CarDetailDTO() {
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

    public List<CarServiceDetailDTO> getCarServices() {
        return carServices;
    }

    public void setCarServices(List<CarServiceDetailDTO> carServices) {
        this.carServices = carServices;
    }

    @Override
    public String toString() {
        return "CarDetailDTO{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", color='" + color + '\'' +
                ", extras='" + extras + '\'' +
                ", carModel=" + carModel +
                ", engine=" + engine +
                ", carServices=" + carServices +
                '}';
    }
}
