package com.ad.GestionCoches.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "car_service")
public class CarService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_detail_id", nullable = false)
    private CarDetail carDetail;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceDetail serviceDetail;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    public CarService() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarDetail getCarDetail() {
        return carDetail;
    }

    public void setCarDetail(CarDetail carDetail) {
        this.carDetail = carDetail;
    }

    public ServiceDetail getService() {
        return serviceDetail;
    }

    public void setService(ServiceDetail serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}