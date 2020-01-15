package com.training.projectlogistics.controller;

import com.training.projectlogistics.entity.Delivery_route;
import com.training.projectlogistics.repository.DeliveryRouteRepository;
import com.training.projectlogistics.repository.UserRepository;
import com.training.projectlogistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    //TODO: remove and ensure all functionality is placed in the Services
    @Autowired
    UserRepository userRepository;

    //TODO: remove and ensure all functionality is placed in the Services
    @Autowired
    DeliveryRouteRepository deliveryRouteRepository;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String greetingAll(Model model) {
        Iterable<Delivery_route> routes = deliveryRouteRepository.findAll();
        model.addAttribute("routes", routes);

        return "main_general";
    }

    @GetMapping("/main_authenticated")
    public String greetingAuthenticated(Model model) {
        Iterable<Delivery_route> routes = deliveryRouteRepository.findAll();
        model.addAttribute("routes", routes);

        return "main_authenticated";
    }

    //TODO - create implementation avoiding if-s
    //TODO - implement error handling
    @GetMapping("/cabinet")
    public String returnToAdminCabinet(Principal principal) {
        if (userService.getUserRole(principal.getName()).toString().equals("USER")) {
            return "redirect:/user";
        }
        if (userService.getUserRole(principal.getName()).toString().equals("ADMIN")) {
            return "redirect:/admin";
        }
        return "main_general";
    }
}
