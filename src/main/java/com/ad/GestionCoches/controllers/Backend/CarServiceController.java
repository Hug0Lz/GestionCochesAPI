package com.ad.GestionCoches.controllers.Backend;

import com.ad.GestionCoches.models.ServiceDetail;
import com.ad.GestionCoches.repositories.ServiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/services")
public class CarServiceController {

    @Autowired
    ServiceDetailRepository serviceDetailRepository;


    // Lista todos los DetalleServicio, envía un atributo services (array con los servicios)
    @GetMapping
    public String ListServices(Model model){
        model.addAttribute("services", serviceDetailRepository.findAll());
        if(!model.containsAttribute("servicio")){
            model.addAttribute("servicio",new ServiceDetail());
        }
        return "admin/servicios";
    }

    // Guarda un DetalleServicio
    @PostMapping("/save")
    public String saveService(@ModelAttribute ServiceDetail serviceDetail){
        serviceDetailRepository.save(serviceDetail);
        return "redirect/:admin/services";
    }

    @GetMapping("/edit/{id}")
    public String editServiceDetail(@PathVariable Long id, Model model){
        ServiceDetail serviceDetail = serviceDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de servicio inválido: " + id));
        model.addAttribute("servicio", serviceDetail);
        model.addAttribute("servicios", serviceDetailRepository.findAll());
        return "admin/servicios";
    }

    @GetMapping("/delete/{id}")
    public String deleteServiceDetail(@PathVariable Long id){
        serviceDetailRepository.deleteById(id);
        return "redirect:/admin/services";
    }
}
