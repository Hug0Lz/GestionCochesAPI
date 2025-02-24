package com.ad.GestionCoches.repositories;

import com.ad.GestionCoches.models.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail, Long> {
}