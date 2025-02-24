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
        return null;
        //todo implementar método para recibir placa por la propia matrícula

    }

    public LicensePlate updateLicensePlate(LicensePlate licensePlate) {
        LicensePlate lp = licensePlateRepository.findById(licensePlate.getId()).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la matrícula con id " + licensePlate.getId()));
        lp.setPlate_number(licensePlate.getPlate_number());
        lp.setCar_id(licensePlate.getCar_id());
        lp.setState(licensePlate.getState());
        return licensePlateRepository.save(lp);
    }

    public void deleteLicensePlate(Long id){
        LicensePlate licensePlate = licensePlateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la matrícula con el id " + id));
        licensePlateRepository.delete(licensePlate);
    }
}
