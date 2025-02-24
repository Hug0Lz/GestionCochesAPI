package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.CarEngine;
import com.ad.GestionCoches.repositories.CarEngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarEngineService {
    @Autowired
    private CarEngineRepository carEngineRepository;

    public List<CarEngine> getAllCarEngines() {
        return carEngineRepository.findAll();
    }


    public CarEngine getCarEngineById(Long id) {
        return carEngineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el motor con el id " + id));
    }

    public CarEngine updateCarEngine(CarEngine carEngine) {
        CarEngine ce = carEngineRepository.findById(carEngine.getId()).orElseThrow(() -> new IllegalArgumentException("No se ha podido actualizar el motor: El id " + carEngine.getId() + " no existe"));

        ce.setFuelType(ce.getFuelType());
        ce.setDrivetrain(carEngine.getDrivetrain());
        ce.setEngineCode(carEngine.getEngineCode());
        ce.setEngineTorque(carEngine.getEngineTorque());
        ce.setEngineDisplacement(carEngine.getEngineDisplacement());
        ce.setCylinderNumber(carEngine.getCylinderNumber());
        ce.setInjectionSystem(carEngine.getInjectionSystem());
        ce.setEngineAspiration(carEngine.getEngineAspiration());
        ce.setMaximumSpeed(carEngine.getMaximumSpeed());
        ce.setAcceleration(carEngine.getAcceleration());

        return carEngineRepository.save(ce);
    }

    public void deleteCarEngine(Long id) {
        CarEngine ce = carEngineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el coche con id " + id));
        carEngineRepository.delete(ce);
    }
}
