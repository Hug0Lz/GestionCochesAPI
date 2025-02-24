package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.Brand;
import com.ad.GestionCoches.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las marcas de coches.
 */
@Service
public class BrandService {

    private final BrandRepository brandRepository;

    /**
     * Constructor para inyectar el repositorio de marcas.
     *
     * @param brandRepository el repositorio de marcas
     */
    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    /**
     * Crea una nueva marca.
     *
     * @param brand la marca a crear
     * @return la marca creada
     */
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    /**
     * Obtiene todas las marcas.
     *
     * @return una lista de todas las marcas
     */
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    /**
     * Obtiene una marca por su ID.
     *
     * @param id el ID de la marca
     * @return una opción que contiene la marca si se encuentra, o vacía si no
     */
    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    /**
     * Actualiza una marca existente.
     *
     * @param id el ID de la marca a actualizar
     * @param brandDetails los detalles de la marca a actualizar
     * @return la marca actualizada
     * @throws RuntimeException si la marca no se encuentra
     */
    public Brand updateBrand(Long id, Brand brandDetails) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado ninguna marca con el id " + id));

        brand.setName(brandDetails.getName());
        brand.setCountry(brandDetails.getCountry());

        return brandRepository.save(brand);
    }

    /**
     * Elimina una marca por su ID.
     *
     * @param id el ID de la marca a eliminar
     * @throws RuntimeException si la marca no se encuentra
     */
    public void deleteBrand(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado ninguna marca con el id " + id));
        brandRepository.delete(brand);
    }
}