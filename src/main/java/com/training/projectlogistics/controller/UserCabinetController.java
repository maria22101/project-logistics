package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.model.enums.CargoType;
import com.training.projectlogistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return "userCabinet";
    }

    @GetMapping("/placeOrder")
    public String placeOrder(Model model) {
        model.addAttribute("orderDTO", new OrderDTO());
        model.addAttribute("cargoTypes", CargoType.values());
        return "placeOrder";
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
