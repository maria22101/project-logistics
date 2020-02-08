package com.training.projectlogistics.controller;

import com.training.projectlogistics.controller.unility.OrderFormValidator;
import com.training.projectlogistics.exceptions.DatabaseIssueException;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.dto.OrderDTO;
import com.training.projectlogistics.enums.CargoType;
import com.training.projectlogistics.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Locale;

import static com.training.projectlogistics.constants.TextConstants.DATABASE_ISSUE;

@Slf4j
@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    private OrderCreationService orderCreationService;
    private OrderService orderService;
    private InvoiceService invoiceService;
    private OrderFormValidator orderFormValidator;

    @Autowired
    public UserController(OrderCreationService orderCreationService,
                          OrderService orderService,
                          InvoiceService invoiceService,
                          OrderFormValidator orderFormValidator) {
        this.orderCreationService = orderCreationService;
        this.orderService = orderService;
        this.invoiceService = invoiceService;
        this.orderFormValidator = orderFormValidator;
    }

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
    public String addOrder(@ModelAttribute @Valid OrderDTO orderDTO,
                           BindingResult result,
                           Principal principal)
            throws DatabaseIssueException {

        log.info("inside UserController, inside addOrder() before validation");

        orderFormValidator.validate(orderDTO, result);
        if (result.hasErrors()) {
            log.info("inside UserController, inside addOrder(): checked that form has errors");
            return "userCabinet/placeOrder";
        }

        orderCreationService.addOrder(principal.getName(), orderDTO);

        return "redirect:/user";
    }

    @ExceptionHandler(DatabaseIssueException.class)
    public String handleDatabaseIssueException(DatabaseIssueException ex,
                                               Model model) {
        model.addAttribute("errorMessage", DATABASE_ISSUE);

        return "general/error";
    }
}
