package com.ad.GestionCoches.repositories;

import com.ad.GestionCoches.models.ServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceDetail, Long> {
}