package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.dto.DeliveryOrderDTO;
import com.training.projectlogistics.repository.DeliveryOrderRepository;
import com.training.projectlogistics.repository.UserRepository;
import com.training.projectlogistics.service.DeliveryOrderService;
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
    UserRepository userRepository;

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    DeliveryOrderService deliveryOrderService;

    //
    @GetMapping
    public String greetUser(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("deliveryOrderDTO", new DeliveryOrderDTO());
        return "userCabinet";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addDeliveryOrder(@ModelAttribute("deliveryOrderDTO") @Valid DeliveryOrderDTO deliveryOrderDTO,
                                   BindingResult bindingResult,
                                   Principal principal,
                                   Model model) {

        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
        }

        deliveryOrderService.addDeliveryOrder(principal.getName(), deliveryOrderDTO);

        return "redirect:/user";
    }


}
