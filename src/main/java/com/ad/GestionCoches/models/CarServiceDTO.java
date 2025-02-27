package com.ad.GestionCoches.models;

import java.time.LocalDate;

public class CarServiceDTO {
    private Long idService;
    private LocalDate startDate;
    private LocalDate endDate;

    public CarServiceDTO(Long idService, LocalDate startDate, LocalDate endDate) {
        this.idService = idService;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CarServiceDTO() {
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
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
