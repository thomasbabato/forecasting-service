package com.tomforecastingservice.forecasting_service.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    /*
    It maps the POST form and the fields of the form are directly mapped in the RegistrationRequest class impl
     */
    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute RegistrationRequest request) {
        registrationService.register(request);
        return "redirect:/login";
    }
}
