package com.ad.GestionCoches.repositories;

import com.ad.GestionCoches.models.CarService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Long> {
}