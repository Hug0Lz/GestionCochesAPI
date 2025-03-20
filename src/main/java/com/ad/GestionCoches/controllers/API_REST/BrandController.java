package com.ad.GestionCoches.controllers.API_REST;

import com.ad.GestionCoches.models.Brand;
import com.ad.GestionCoches.services.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Operation(summary = "Obtener todas las marcas", description = "Devuelve una lista de todas las marcas de coches.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de marcas obtenida exitosamente")
    })
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @Operation(summary = "Obtener una marca por ID", description = "Devuelve una marca de coche especificada por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marca encontrada"),
            @ApiResponse(responseCode = "404", description = "Marca no encontrada")
    })
    
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        Brand brand = brandService.getBrandById(id);
        if (brand == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brand);
    }

    @Operation(summary = "Agregar una nueva marca", description = "Crea una nueva marca de coche.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Marca creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para crear la marca")
    })
    @PostMapping
    public Brand addBrand(
            @Parameter(description = "Marca de coche que se va a agregar") @RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }

    @Operation(summary = "Actualizar una marca", description = "Actualiza los detalles de una marca de coche.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marca actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualizar la marca"),
            @ApiResponse(responseCode = "404", description = "Marca no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(
            @Parameter(description = "ID de la marca que se desea actualizar") @PathVariable Long id,
            @Parameter(description = "Detalles de la marca a actualizar") @RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.updateBrand(id, brand));
    }

    @Operation(summary = "Eliminar una marca", description = "Elimina una marca de coche especificada por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Marca eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Marca no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteBrand(
            @Parameter(description = "ID de la marca que se desea eliminar") @PathVariable Long id) {
        brandService.deleteBrand(id);
    }
}
