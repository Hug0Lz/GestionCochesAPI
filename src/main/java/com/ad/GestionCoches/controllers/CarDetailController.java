package com.ad.GestionCoches.controllers;

import com.ad.GestionCoches.models.CarDetail;
import com.ad.GestionCoches.models.CarDetailDTO;
import com.ad.GestionCoches.models.CarService;
import com.ad.GestionCoches.models.CarServiceDTO;
import com.ad.GestionCoches.services.CarDetailService;
import com.ad.GestionCoches.services.ServiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars/detail")
public class CarDetailController {

    @Autowired
    public CarDetailService carDetailService;

    @Autowired
    ServiceDetailService serviceDetailService;

    @GetMapping
    public List<CarDetailDTO> getAllCarDetails() {
        return carDetailService.getAllCarDetail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDetailDTO> getCarDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(carDetailService.getCarDetailById(id));
    }

    @PutMapping
    public ResponseEntity<CarDetailDTO> updateCarDetail(@PathVariable Long id, @RequestBody CarDetail cd){
        return ResponseEntity.ok(carDetailService.updateCarDetail(id,cd));
    }

    @PutMapping("/{idCar}/addService")
    public ResponseEntity<CarDetailDTO> addServiceToCar(@PathVariable Long idCar, @RequestBody CarServiceDTO carServiceDTO){
        return ResponseEntity.ok(carDetailService.addServiceToCar(idCar, carServiceDTO));
    }
}
