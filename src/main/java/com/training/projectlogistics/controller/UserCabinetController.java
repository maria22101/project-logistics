package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.model.enums.CargoType;
import com.training.projectlogistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserCabinetController {

    @Autowired
    OrderService orderService;

    //TODO - find option to fill object in post
    @GetMapping
    public String greetUser(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "userCabinet/userMain";
    }

    @GetMapping("/placeOrder")
    public String placeOrder(Model model) {
        model.addAttribute("orderDTO", new OrderDTO());
        model.addAttribute("cargoTypes", CargoType.values());
        return "userCabinet/placeOrder";
    }

    @PostMapping("/placeOrder")
    public String addOrder(@ModelAttribute("orderDTO") OrderDTO orderDTO,
                                   BindingResult bindingResult,
                                   Principal principal,
                                   Model model) {

        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
        }

        orderService.addOrder(principal.getName(), orderDTO);

        return "redirect:/user";
    }
}
