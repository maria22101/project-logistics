package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.model.enums.CargoType;
import com.training.projectlogistics.service.AdminService;
import com.training.projectlogistics.service.OrderCreationService;
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
    private AdminService adminService;
    private OrderCreationService orderCreationService;
    private OrderService orderService;

    @Autowired
    public UserCabinetController(AdminService adminService,
                                 OrderCreationService orderCreationService,
                                 OrderService orderService) {
        this.adminService = adminService;
        this.orderCreationService = orderCreationService;
        this.orderService = orderService;
    }

    //TODO - find option to fill object in post
    @GetMapping
    public String greetUser(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "userCabinet/userMain";
    }

    @GetMapping("/orders")
    public String displayAllOrders(Principal principal, Model model) {
        model.addAttribute("orders", orderService.getOrdersByUserName(principal.getName()));

        return "userCabinet/userOrders";
    }

    @GetMapping("/invoicedOrders")
    public String displayOpenOrders(Principal principal, Model model) {
        model.addAttribute("openOrders", orderService.getOpenOrdersByUserName(principal.getName()));

        return "userCabinet/userInvoicedOrders";
    }

    @PostMapping("/invoicedOrders")
    public String displayEditedOrders(@RequestParam("orderNumber") Long orderNumber) {
        Order payingOrder = orderService.getOrderByNumber(orderNumber);
        //implement userService method payIvoice()

        return "redirect:/user";
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

        orderCreationService.addOrder(principal.getName(), orderDTO);

        return "redirect:/user";
    }
}
