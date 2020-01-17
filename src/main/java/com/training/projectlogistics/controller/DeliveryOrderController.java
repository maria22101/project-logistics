package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.dto.DeliveryOrderDTO;
import com.training.projectlogistics.repository.DeliveryOrderRepository;
import com.training.projectlogistics.repository.UserRepository;
import com.training.projectlogistics.service.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

//@Controller
//@RequestMapping("/userCabinet")
public class DeliveryOrderController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    DeliveryOrderService deliveryOrderService;

//    @PostMapping()
//    public String addDeliveryOrder(@Valid @ModelAttribute DeliveryOrderDTO deliveryOrderDTO,
//                                   BindingResult result,
//                                   Principal principal,
//                                   Model model) {
//
//        if (result.hasErrors()) {
//            return "userCabinet";
//        }
//
//        deliveryOrderService.addDeliveryOrder(principal.getName(), deliveryOrderDTO);
//
//        return "redirect:/userCabinet";
//    }

}
