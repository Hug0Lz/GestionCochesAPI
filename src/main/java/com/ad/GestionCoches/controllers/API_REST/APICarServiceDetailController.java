package com.ad.GestionCoches.controllers.API_REST;

import com.ad.GestionCoches.models.ServiceDetail;
import com.ad.GestionCoches.services.CarDetailService;
import com.ad.GestionCoches.services.CarServiceService;
import com.ad.GestionCoches.services.ServiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class APICarServiceDetailController {
    @Autowired
    private ServiceDetailService serviceDetailService;

    @GetMapping
    public List<ServiceDetail> getAllServices(){
        return serviceDetailService.getAllService();
    }

    @GetMapping("/{id}")
    public ServiceDetail getServiceDetailById(@PathVariable Long id){
        return serviceDetailService.getServiceById(id);
    }


}
