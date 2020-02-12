package com.training.projectlogistics.controller;

import com.training.projectlogistics.controller.validation.OrderFormRegexValidator;
import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.exceptions.DatabaseSaveException;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.controller.dto.OrderDTO;
import com.training.projectlogistics.enums.CargoType;
import com.training.projectlogistics.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    private OrderCreationService orderCreationService;
    private OrderService orderService;
    private InvoiceService invoiceService;
    private RouteService routeService;
    private OrderFormRegexValidator orderFormRegexValidator;

    @Autowired
    public UserController(OrderCreationService orderCreationService,
                          OrderService orderService,
                          InvoiceService invoiceService,
                          RouteService routeService,
                          OrderFormRegexValidator orderFormRegexValidator) {
        this.orderCreationService = orderCreationService;
        this.orderService = orderService;
        this.invoiceService = invoiceService;
        this.routeService = routeService;
        this.orderFormRegexValidator = orderFormRegexValidator;
    }

    @GetMapping
    public String greetUser(@AuthenticationPrincipal User user,
                            Model model) {
        model.addAttribute("name", user.getName());

        return "userCabinet/userMain";
    }



    @GetMapping("/placeOrder")
    public String placeOrder(Model model)
            throws DatabaseFetchException {

        log.info("dispatchCitiesOptions: " + routeService.getCitiesOptions());

        model.addAttribute("orderDTO", new OrderDTO());
        model.addAttribute("routeCities", routeService.getCitiesOptions());
        model.addAttribute("cargoTypes", CargoType.values());

//        log.info("routeCities: " + routeCities);
//        log.info("cargoTypes: " + Arrays.toString(cargoTypes));

        return "userCabinet/placeOrder";
    }

    @PostMapping("/placeOrder")
    public String addOrder(@ModelAttribute @Valid OrderDTO orderDTO,
                           BindingResult result,
                           Principal principal,
                           Model model)
            throws DatabaseFetchException, DatabaseSaveException {

        log.info("inside UserController, inside addOrder() before validation");

        orderFormRegexValidator.validate(orderDTO, result);
        if (result.hasErrors()) {
            log.info("inside UserController, inside addOrder(): checked that form has errors");
            model.addAttribute("routeCities", routeService.getCitiesOptions());
            model.addAttribute("cargoTypes", CargoType.values());
            return "userCabinet/placeOrder";
        }

        log.info("OrderDTO created: " + orderDTO.toString());

        orderCreationService.addOrder(principal.getName(), orderDTO);

        return "redirect:/user";
    }

    @GetMapping("/orders")
    public String displayAllOrders(Principal principal, Model model)
            throws DatabaseFetchException {

        model.addAttribute("orders", orderService.getOrdersByEmail(principal.getName()));

        return "userCabinet/orders";
    }

    @GetMapping("/invoicedOrders")
    public String displayOpenOrders(Principal principal, Model model)
            throws DatabaseFetchException {

        model.addAttribute("openOrders", orderService.getInvoicedOrdersByEmail(principal.getName()));

        return "userCabinet/invoicedOrders";
    }

    @GetMapping("/invoicedOrders/{orderNumber}")
    public String displayOrderDetails(@PathVariable("orderNumber") Long orderNumber,
                                      Model model)
            throws DatabaseFetchException {

        model.addAttribute("order", orderService.getOrderByNumber(orderNumber));

        return "userCabinet/orderDetails";
    }

    @PostMapping("/invoicedOrders/{orderNumber}")
    public String payOrder(@PathVariable("orderNumber") Long orderNumber)
            throws DatabaseFetchException, DatabaseSaveException {

        invoiceService.payInvoiceOfOrderNumber(orderNumber);

        return "redirect:/user/invoicedOrders";
    }

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseFetchException(DatabaseFetchException e, Model model) {
        model.addAttribute("errorMessage", e.toString());

        return "general/error";
    }

    @ExceptionHandler(DatabaseSaveException.class)
    public String handleDatabaseSaveException(DatabaseSaveException e, Model model) {
        model.addAttribute("errorMessage", e.toString());

        return "general/error";
    }
}
