package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

public class CarServiceDTO {

    @Schema(description = "ID único del servicio de coche", example = "1")
    private Long idService;

    @Schema(description = "Fecha de inicio del servicio", example = "2025-02-27")
    private LocalDate startDate;

    @Schema(description = "Fecha de finalización del servicio", example = "2025-03-05")
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
