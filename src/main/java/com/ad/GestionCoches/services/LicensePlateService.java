package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.LicensePlate;
import com.ad.GestionCoches.repositories.LicensePlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicensePlateService {
    @Autowired
    private LicensePlateRepository licensePlateRepository;

    public List<LicensePlate> getAllLicensePlate() {
        return licensePlateRepository.findAll();
    }

    public LicensePlate getLicensePlateById(Long id) {
        return licensePlateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la matrícula con id " + id));
    }

    public LicensePlate getLicensePlateByPlate(String plate) {
        return licensePlateRepository.findByplateNumber(plate);
    }

    public LicensePlate addLicensePlate(LicensePlate licensePlate){
        return licensePlateRepository.save(licensePlate);
    }

    public LicensePlate updateLicensePlate(Long id, LicensePlate licensePlate) {
        LicensePlate lp = licensePlateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la matrícula con id " + licensePlate.getId()));
        lp.setPlateNumber(licensePlate.getPlateNumber());
        lp.setCarId(licensePlate.getCarId());
        lp.setState(licensePlate.getState());
        return licensePlateRepository.save(lp);
    }

    public void deleteLicensePlate(Long id){
        LicensePlate licensePlate = licensePlateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la matrícula con el id " + id));
        licensePlateRepository.delete(licensePlate);
    }

    public LicensePlate getLicensePlateByCarId(Long id) {
        return licensePlateRepository.findByCarId(id);
    }
}
