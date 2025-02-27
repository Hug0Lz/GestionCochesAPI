package com.ad.GestionCoches.controllers;

import com.ad.GestionCoches.models.CarModel;
import com.ad.GestionCoches.services.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/cars/model")
public class CarModelController {
    @Autowired
    private CarModelService carModelService;

    @GetMapping
    public List<CarModel> getAllCarModels() {
        return carModelService.getAllCarModels();
    }

    @GetMapping("/{id}")
public ResponseEntity<CarModel> getCarModelById(@PathVariable Long id){
        return ResponseEntity.ok(carModelService.getCarModelById(id));
    }

    @PostMapping
    public ResponseEntity<CarModel> addCarModel(@RequestBody CarModel cm) {
        CarModel carModel = carModelService.createCarModel(cm);
        return ResponseEntity.status(HttpStatus.CREATED).body(carModel);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CarModel> updateCarModel(@PathVariable Long id, @RequestBody CarModel carModel) {
        return ResponseEntity.ok(carModelService.updateCarModel(id, carModel));
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarModel(@PathVariable Long id) {
        carModelService.deleteCarModel(id);
        return ResponseEntity.noContent().build();

    }
}