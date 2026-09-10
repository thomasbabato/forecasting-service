package com.tomforecastingservice.forecasting_service.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Loads the page home.html from the folder src/main/resources/templates
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
