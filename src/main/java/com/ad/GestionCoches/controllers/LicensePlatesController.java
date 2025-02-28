package com.ad.GestionCoches.controllers;

import com.ad.GestionCoches.models.LicensePlate;
import com.ad.GestionCoches.services.LicensePlateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licensePlates")
public class LicensePlatesController {

    @Autowired
    private LicensePlateService licensePlateService;

    @Operation(summary = "Obtener todas las matrículas", description = "Devuelve una lista de todas las matrículas registradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matrículas obtenidas exitosamente")
    })
    @GetMapping
    public List<LicensePlate> getAllLicensePlates() {
        return licensePlateService.getAllLicensePlate();
    }

    @Operation(summary = "Obtener matrícula por ID", description = "Devuelve los detalles de una matrícula especificada por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matrícula encontrada"),
            @ApiResponse(responseCode = "404", description = "Matrícula no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LicensePlate> getLicensePlateById(
            @Parameter(description = "ID de la matrícula a obtener") @PathVariable Long id) {
        return ResponseEntity.ok(licensePlateService.getLicensePlateById(id));
    }

    @Operation(summary = "Obtener matrícula por número de matrícula", description = "Devuelve los detalles de una matrícula especificada por su número.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matrícula encontrada"),
            @ApiResponse(responseCode = "404", description = "Matrícula no encontrada")
    })
    @GetMapping("/")
    public ResponseEntity<LicensePlate> getLicensePlateByLicense(
            @Parameter(description = "Número de la matrícula a obtener") @RequestParam String licensePlate) {
        return ResponseEntity.ok(licensePlateService.getLicensePlateByPlate(licensePlate));
    }

    @Operation(summary = "Obtener matrícula por ID de coche", description = "Devuelve los detalles de la matrícula asociada a un coche especificado por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matrícula encontrada"),
            @ApiResponse(responseCode = "404", description = "Matrícula no encontrada")
    })
    @GetMapping("/car/{idCar}")
    public ResponseEntity<LicensePlate> getLicenseByCarId(
            @Parameter(description = "ID del coche al que pertenece la matrícula") @PathVariable Long idCar) {
        return ResponseEntity.ok(licensePlateService.getLicensePlateByCarId(idCar));
    }

    @Operation(summary = "Agregar una nueva matrícula", description = "Crea una nueva matrícula en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Matrícula creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para crear la matrícula")
    })
    @PostMapping
    public LicensePlate addLicensePlate(
            @Parameter(description = "Detalles de la matrícula a crear") @RequestBody LicensePlate licensePlate) {
        return licensePlateService.addLicensePlate(licensePlate);
    }

    @Operation(summary = "Actualizar matrícula", description = "Actualiza los detalles de una matrícula especificada por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matrícula actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualizar la matrícula"),
            @ApiResponse(responseCode = "404", description = "Matrícula no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LicensePlate> updateLicensePlate(
            @Parameter(description = "ID de la matrícula a actualizar") @PathVariable Long id,
            @Parameter(description = "Detalles de la matrícula a actualizar") @RequestBody LicensePlate licensePlate) {
        return ResponseEntity.ok(licensePlateService.updateLicensePlate(id, licensePlate));
    }

    @Operation(summary = "Eliminar matrícula", description = "Elimina una matrícula especificada por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Matrícula eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Matrícula no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteLicensePlate(
            @Parameter(description = "ID de la matrícula a eliminar") @PathVariable Long id) {
        licensePlateService.deleteLicensePlate(id);
    }
}
