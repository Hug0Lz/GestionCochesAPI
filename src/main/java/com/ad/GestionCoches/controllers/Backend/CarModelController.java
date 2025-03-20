package com.ad.GestionCoches.controllers.Backend;

import com.ad.GestionCoches.models.CarModel;
import com.ad.GestionCoches.repositories.CarModelRepository;
import com.ad.GestionCoches.services.BrandService;
import com.ad.GestionCoches.services.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/carModel")
public class CarModelController {

    @Autowired
    CarModelService carModelService;

    @Autowired
    CarModelRepository carModelRepository;

    @Autowired
    BrandService brandService;

    @GetMapping
    public String listAllCarModel(Model model){
        model.addAttribute("modelos", carModelService.getAllCarModels());
        if(!model.containsAttribute("modelo")){
            model.addAttribute("modelo", new CarModel());
        }
        model.addAttribute("brands", brandService.getAllBrands());
        return "admin/modelos";
    }


    @PostMapping("/save")
    public String saveCarModel(@ModelAttribute CarModel carModel){
        carModelRepository.save(carModel);
        return "redirect:/admin/carModel";
    }

    @GetMapping("/edit/{id}")
    public String editCarModel(@PathVariable Long id, Model model){
        CarModel carModel = carModelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID del modelo inválido: " + id));
        model.addAttribute("modelo",carModel);
        model.addAttribute("modelos",carModelRepository.findAll());
        model.addAttribute("brands", brandService.getAllBrands());
        return "admin/modelos";
    }

    @GetMapping("/delete/{id}")
    public String deleteCarModel(@PathVariable Long id){
        carModelService.deleteCarModel(id);
        return "redirect:/admin/carModel";
    }


}
