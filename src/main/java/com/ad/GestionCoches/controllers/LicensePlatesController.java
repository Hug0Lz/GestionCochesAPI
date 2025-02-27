package com.ad.GestionCoches.controllers;

import com.ad.GestionCoches.models.LicensePlate;
import com.ad.GestionCoches.services.LicensePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licensePlates")
public class LicensePlatesController {

    @Autowired
    private LicensePlateService licensePlateService;


    @GetMapping
    public List<LicensePlate> getAllLicensePlates(){
        return licensePlateService.getAllLicensePlate();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LicensePlate> getLicensePlateById(@PathVariable Long id){
        return ResponseEntity.ok(licensePlateService.getLicensePlateById(id));
    }

    @GetMapping("/")
    public ResponseEntity<LicensePlate> getLicensePlateByLicense( @RequestParam String licensePlate){
        return ResponseEntity.ok(licensePlateService.getLicensePlateByPlate(licensePlate));
    }

    @GetMapping("/car/{idCar}")
    public ResponseEntity<LicensePlate> getLicenseByCarId(@PathVariable Long idCar){
        return ResponseEntity.ok(licensePlateService.getLicensePlateByCarId(idCar));
    }

    @PostMapping
    public LicensePlate addLicensePlate(@RequestBody LicensePlate licensePlate){
        return licensePlateService.addLicensePlate(licensePlate);
    }

    @PutMapping("/{id}")
   public ResponseEntity<LicensePlate> updateLicensePlate(@PathVariable Long id, @RequestBody LicensePlate licensePlate){
        return ResponseEntity.ok(licensePlateService.updateLicensePlate(id,licensePlate));
    }

    @DeleteMapping("/{id}")
    public void deleteLicensePlate(@PathVariable Long id){
        licensePlateService.deleteLicensePlate(id);
    }
}
