package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.model.enums.CargoType;
import com.training.projectlogistics.service.InvoiceService;
import com.training.projectlogistics.service.OrderCreationService;
import com.training.projectlogistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserController {
    private OrderCreationService orderCreationService;
    private OrderService orderService;
    private InvoiceService invoiceService;


    @Autowired
    public UserController(OrderCreationService orderCreationService,
                          OrderService orderService,
                          InvoiceService invoiceService) {
        this.orderCreationService = orderCreationService;
        this.orderService = orderService;
        this.invoiceService = invoiceService;
    }

    //TODO - find option to fill object in post
    @GetMapping
    public String greetUser(@AuthenticationPrincipal User user,
                            Model model) {
        model.addAttribute("name", user.getName());
        return "userCabinet/userMain";
    }

    @GetMapping("/orders")
    public String displayAllOrders(Principal principal, Model model) {
        model.addAttribute("orders", orderService.getOrdersByEmail(principal.getName()));

        return "userCabinet/orders";
    }

    @GetMapping("/invoicedOrders")
    public String displayOpenOrders(Principal principal, Model model) {
        model.addAttribute("openOrders", orderService.getInvoicedOrdersByEmail(principal.getName()));

        return "userCabinet/invoicedOrders";
    }

    @PostMapping("/invoicedOrders")
    public String displayEditedOrders(@RequestParam("orderNumber") Long orderNumber) {
        invoiceService.payInvoiceOfOrderNumber(orderNumber);

        return "redirect:/user/invoicedOrders";
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
