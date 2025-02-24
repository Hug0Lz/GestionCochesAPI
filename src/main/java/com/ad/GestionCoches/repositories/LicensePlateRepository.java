package com.ad.GestionCoches.repositories;

import com.ad.GestionCoches.models.LicensePlate; // Asegúrate de que la ruta sea correcta
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicensePlateRepository extends JpaRepository<LicensePlate, Long> {
}