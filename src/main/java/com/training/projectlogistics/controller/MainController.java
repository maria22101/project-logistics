package com.training.projectlogistics.controller;

import com.training.projectlogistics.entity.Delivery_route;
import com.training.projectlogistics.repository.DeliveryRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class MainController {

    @Autowired
    DeliveryRouteRepository deliveryRouteRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        Iterable<Delivery_route> routes = deliveryRouteRepository.findAll();
        model.addAttribute("routes", routes);

        return "main";
    }

    @GetMapping("/login")
    public String enterLogin(Locale locale, Model model) {
//        Locale currentLocale = LocaleContextHolder.getLocale();
//        model.addAttribute("locale", currentLocale);
        return "login";
    }

}
