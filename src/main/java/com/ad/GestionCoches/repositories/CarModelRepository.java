package com.ad.GestionCoches.repositories;

import com.ad.GestionCoches.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}