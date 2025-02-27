package com.ad.GestionCoches.models;

import java.util.ArrayList;
import java.util.List;

public class CarDetailDTO {
    private Long id;
    private String vin;
    private String color;
    private String extras;
    private CarModel carModel;
    private CarEngine engine;
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
}
