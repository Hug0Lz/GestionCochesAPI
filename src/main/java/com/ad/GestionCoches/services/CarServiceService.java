package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.CarService;
import com.ad.GestionCoches.repositories.CarServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceService {
    @Autowired
    private CarServiceRepository carServiceRepository;

    public List<CarService> getAllCarService(){
        return carServiceRepository.findAll();
    }

    public CarService getCarServiceById(Long id){
        return carServiceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el servicio con el id " + id));
    }

    public CarService addService(CarService carService){
        System.out.println("CAR SERVICE: ");
        System.out.println(carService);
        return carServiceRepository.save(carService);
    }

    public CarService updateCarService(CarService carService){
        CarService cs = carServiceRepository.findById(carService.getId()).orElseThrow(() ->new IllegalArgumentException("No se ha encontrado el servicio con el id " + carService.getId()));
        return carServiceRepository.save(cs);
    }

    public void deleteCarService(Long id){
        CarService cs = carServiceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el servicio con el id " + id));
        carServiceRepository.delete(cs);
    }

}
