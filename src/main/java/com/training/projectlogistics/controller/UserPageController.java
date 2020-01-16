package com.training.projectlogistics.controller;

import com.training.projectlogistics.repository.UserRepository;
import com.training.projectlogistics.service.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserPageController {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    DeliveryOrderService deliveryOrderService;

    @GetMapping
    public String greetUser(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "userCabinet";
    }

    @PostMapping()
    public String addDeliveryOrder() {

        return "redirect:/user";
    }


}
