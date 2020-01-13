package com.training.projectlogistics.controller;

import com.training.projectlogistics.entity.Delivery_route;
import com.training.projectlogistics.repository.DeliveryRouteRepository;
import com.training.projectlogistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeliveryRouteRepository deliveryRouteRepository;

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

    @GetMapping("/cabinet")
    public String returnToAdminCabinet(Principal principal) {
////if(principal.getName())
//        return "redirect:/user";
//
////        return "redirect:/adminCabinet";
    }

}
