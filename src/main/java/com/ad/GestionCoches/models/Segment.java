package com.ad.GestionCoches.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Segmento del coche. Representa el tipo de segmento en el que se clasifica el vehículo.")
public enum Segment {

    @Schema(description = "Micro", example = "A")
    A, // Micro

    @Schema(description = "Pequeño", example = "B")
    B, // Pequeño

    @Schema(description = "Compacto", example = "C")
    C, // Compacto

    @Schema(description = "Mediano", example = "D")
    D, // Mediano

    @Schema(description = "Grande", example = "E")
    E, // Grande

    @Schema(description = "Lujo", example = "F")
    F, // Lujo

    @Schema(description = "SUV", example = "J")
    J, // SUV

    @Schema(description = "Monovolumen", example = "M")
    M, // Monovolumen

    @Schema(description = "Deportivo", example = "S")
    S  // Deportivo
}
