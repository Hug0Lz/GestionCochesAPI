package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "car_service")
public class CarService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del servicio del coche", example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_detail_id", nullable = false)
    @NotNull
    @Schema(description = "Detalles del coche asociado a este servicio", example = "CarDetail object")
    private CarDetail carDetail;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @NotNull
    @Schema(description = "Detalles del servicio realizado", example = "ServiceDetail object")
    private ServiceDetail serviceDetail;

    @Column(name = "start_date", nullable = false)
    @NotNull
    @Schema(description = "Fecha de inicio del servicio", example = "2023-02-25")
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @NotNull
    @Schema(description = "Fecha de finalización del servicio", example = "2023-03-01")
    private LocalDate endDate;

    public CarService() {
    }

    public CarService(Long id, CarDetail carDetail, ServiceDetail serviceDetail, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.carDetail = carDetail;
        this.serviceDetail = serviceDetail;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CarService(CarDetail carDetail, ServiceDetail serviceDetail, LocalDate startDate, LocalDate endDate) {
        this.carDetail = carDetail;
        this.serviceDetail = serviceDetail;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public ServiceDetail getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(ServiceDetail serviceDetail) {
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

    @Override
    public String toString() {
        return "CarService{" +
                "id=" + id +
                ", carDetail=" + carDetail +
                ", serviceDetail=" + serviceDetail +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
