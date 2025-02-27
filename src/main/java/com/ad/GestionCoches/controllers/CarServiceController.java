package com.ad.GestionCoches.controllers;

import com.ad.GestionCoches.services.CarServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services")
public class CarServiceController {
    @Autowired
    private CarServiceService carServiceService;


}
