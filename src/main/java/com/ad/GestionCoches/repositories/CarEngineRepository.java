package com.ad.GestionCoches.repositories;

import com.ad.GestionCoches.models.CarEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEngineRepository extends JpaRepository<CarEngine, Long> {
}