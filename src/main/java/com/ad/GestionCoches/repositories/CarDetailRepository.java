package com.ad.GestionCoches.repositories;

import com.ad.GestionCoches.models.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail, Long> {
    public List<CarDetail> findByCarModelId(Long id);
    public List<CarDetail> findByCarServicesServiceDetailId(Long id);
}