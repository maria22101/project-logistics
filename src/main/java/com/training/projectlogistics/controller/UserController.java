package com.training.projectlogistics.controller;

import com.training.projectlogistics.repository.DeliveryOrderRepository;
import com.training.projectlogistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;
}
