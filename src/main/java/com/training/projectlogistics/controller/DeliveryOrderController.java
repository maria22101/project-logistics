package com.training.projectlogistics.controller;

import com.training.projectlogistics.repository.OrderRepository;
import com.training.projectlogistics.repository.UserRepository;
import com.training.projectlogistics.service.OrderCreationService;
import org.springframework.beans.factory.annotation.Autowired;

//@Controller
//@RequestMapping("/userCabinet")
public class DeliveryOrderController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderCreationService orderCreationService;

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
