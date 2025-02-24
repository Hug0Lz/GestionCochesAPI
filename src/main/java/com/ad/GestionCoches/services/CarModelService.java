package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.CarModel;
import com.ad.GestionCoches.repositories.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarModelService {
    @Autowired
    private CarModelRepository carModelRepository;


    public CarModel createCarModel(CarModel carModel) {
        return carModelRepository.save(carModel);
    }


    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }


    public CarModel getCarModelById(Long id) {
        return carModelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el coche con el id" + id));
    }


    public CarModel updateCarModel(Long id, CarModel carModel) {
        CarModel cm = carModelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el coche con el id " + id));

        cm.setModel(carModel.getModel());
        cm.setBrand(carModel.getBrand());

        return carModelRepository.save(cm);
    }

    public void deleteCarModel(Long id) {
        CarModel carModel = carModelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el coche con el id " + id));
        carModelRepository.delete(carModel);
    }
}