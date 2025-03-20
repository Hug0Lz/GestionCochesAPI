package com.ad.GestionCoches.controllers.API_REST;

import com.ad.GestionCoches.models.CarDetail;
import com.ad.GestionCoches.models.CarDetailDTO;
import com.ad.GestionCoches.models.CarServiceDTO;
import com.ad.GestionCoches.services.CarDetailService;
import com.ad.GestionCoches.services.ServiceDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars/detail")
public class APICarDetailController {

    @Autowired
    public CarDetailService carDetailService;

    @Autowired
    ServiceDetailService serviceDetailService;

    @Operation(summary = "Obtener todos los detalles de los coches", description = "Devuelve una lista con los detalles de todos los coches.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalles de coches obtenidos exitosamente")
    })
    @GetMapping
    public List<CarDetailDTO> getAllCarDetails() {
        return carDetailService.getAllCarDetail();
    }

    @Operation(summary = "Obtener detalles de un coche por ID", description = "Devuelve los detalles de un coche especificado por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalles del coche encontrados"),
            @ApiResponse(responseCode = "404", description = "Coche no encontrado")
    })

    @GetMapping("/model/{id}")
    public List<CarDetailDTO> getCarDetailsByModelId(@PathVariable Long id){
        return carDetailService.getAllCarDetailByCarModelId(id);
    }

    @GetMapping("/services/{id}")
    public List<CarDetailDTO> getCarDetailByServiceId(@PathVariable Long id){
        return carDetailService.getAllCarDetailByServiceId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDetailDTO> getCarDetailById(
            @Parameter(description = "ID del coche a obtener los detalles") @PathVariable Long id) {
        return ResponseEntity.ok(carDetailService.getCarDetailById(id));
    }

    @Operation(summary = "Actualizar los detalles de un coche", description = "Actualiza los detalles de un coche especificado por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalles del coche actualizados exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualizar el coche"),
            @ApiResponse(responseCode = "404", description = "Coche no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CarDetailDTO> updateCarDetail(
            @Parameter(description = "ID del coche a actualizar") @PathVariable Long id,
            @Parameter(description = "Detalles del coche a actualizar") @RequestBody CarDetail cd) {
        return ResponseEntity.ok(carDetailService.updateCarDetail(id, cd));
    }

    @Operation(summary = "Agregar un servicio a un coche", description = "Añade un servicio al coche especificado por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Servicio agregado exitosamente al coche"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para agregar el servicio al coche"),
            @ApiResponse(responseCode = "404", description = "Coche no encontrado o servicio no válido")
    })
    @PutMapping("/{idCar}/addService")
    public ResponseEntity<CarDetailDTO> addServiceToCar(
            @Parameter(description = "ID del coche al que se agregará el servicio") @PathVariable Long idCar,
            @Parameter(description = "Detalles del servicio a agregar al coche") @RequestBody CarServiceDTO carServiceDTO) {
        return ResponseEntity.ok(carDetailService.addServiceToCar(idCar, carServiceDTO));
    }
}
