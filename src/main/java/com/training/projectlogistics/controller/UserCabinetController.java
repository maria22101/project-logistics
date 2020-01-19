package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("deliveryOrderDTO", new OrderDTO());
        return "userCabinet";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addDeliveryOrder(@ModelAttribute("deliveryOrderDTO") @Valid OrderDTO orderDTO,
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
