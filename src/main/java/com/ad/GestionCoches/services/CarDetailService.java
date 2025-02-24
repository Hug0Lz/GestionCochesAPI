package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.CarDetail;
import com.ad.GestionCoches.repositories.CarDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDetailService {

    @Autowired
    private CarDetailRepository carDetailRepository;

    public List<CarDetail> getAllCarDetail() {
        return carDetailRepository.findAll();
    }

    public CarDetail getCarDetailById(Long id) {
        return carDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el detalle del coche con el id " + id));
    }

    public CarDetail updateCarDetail(CarDetail carDetail) {
        CarDetail cd = carDetailRepository.findById(carDetail.getId()).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el detalle del coche con el id " + carDetail.getId()));

        cd.setVin(cd.getVin());
        cd.setColor(cd.getColor());
        cd.setExtras(cd.getExtras());
        cd.setCarModel(carDetail.getCarModel());
        cd.setEngine(carDetail.getEngine());
        cd.setCarServices(carDetail.getCarServices());

        return carDetailRepository.save(cd);
    }

    public void deleteCarDetail(Long id) {
        CarDetail carDetail = carDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el id " + id));
        carDetailRepository.delete(carDetail);
    }


}
