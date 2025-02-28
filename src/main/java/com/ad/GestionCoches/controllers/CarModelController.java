package com.ad.GestionCoches.controllers;

import com.ad.GestionCoches.models.CarModel;
import com.ad.GestionCoches.services.CarModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars/model")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @Operation(summary = "Obtener todos los modelos de coches", description = "Devuelve una lista con todos los modelos de coches.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelos de coches obtenidos exitosamente")
    })
    @GetMapping
    public List<CarModel> getAllCarModels() {
        return carModelService.getAllCarModels();
    }

    @Operation(summary = "Obtener modelo de coche por ID", description = "Devuelve los detalles de un modelo de coche especificado por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelo de coche encontrado"),
            @ApiResponse(responseCode = "404", description = "Modelo de coche no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CarModel> getCarModelById(
            @Parameter(description = "ID del modelo de coche a obtener") @PathVariable Long id) {
        return ResponseEntity.ok(carModelService.getCarModelById(id));
    }

    @Operation(summary = "Agregar un nuevo modelo de coche", description = "Crea un nuevo modelo de coche en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Modelo de coche creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para crear el modelo de coche")
    })
    @PostMapping
    public ResponseEntity<CarModel> addCarModel(
            @Parameter(description = "Detalles del modelo de coche a crear") @RequestBody CarModel cm) {
        CarModel carModel = carModelService.createCarModel(cm);
        return ResponseEntity.status(HttpStatus.CREATED).body(carModel);
    }

    @Operation(summary = "Actualizar un modelo de coche", description = "Actualiza los detalles de un modelo de coche especificado por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelo de coche actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualizar el modelo de coche"),
            @ApiResponse(responseCode = "404", description = "Modelo de coche no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CarModel> updateCarModel(
            @Parameter(description = "ID del modelo de coche a actualizar") @PathVariable Long id,
            @Parameter(description = "Detalles del modelo de coche a actualizar") @RequestBody CarModel carModel) {
        return ResponseEntity.ok(carModelService.updateCarModel(id, carModel));
    }

    @Operation(summary = "Eliminar un modelo de coche", description = "Elimina un modelo de coche especificado por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Modelo de coche eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Modelo de coche no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarModel(
            @Parameter(description = "ID del modelo de coche a eliminar") @PathVariable Long id) {
        carModelService.deleteCarModel(id);
        return ResponseEntity.noContent().build();
    }
}
