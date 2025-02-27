package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.Brand;
import com.ad.GestionCoches.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar las marcas de coches.
 */
@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;


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
     * @return un objeto Brand si se encuentra, o un IllegalArgumentException si no
     */
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no se ha encontntrado ninguna marca con id " + id));
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
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado ninguna marca con el id " + id));

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
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado ninguna marca con el id " + id));
        brandRepository.delete(brand);
    }
}