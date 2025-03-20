package com.ad.GestionCoches.controllers.Backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

@GetMapping("/dashboard")
    public String dashboard(Model model) {
    return "admin/dashboard";
}

}
