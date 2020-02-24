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

import static com.training.projectlogistics.constants.WebConstants.*;

@Slf4j
@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    private final static String ATTRIBUTE_NAME = "name";
    private final static String USER_MAIN_PAGE = "userCabinet/userMain";
    private final static String USER_PLACE_ORDER_PAGE = "userCabinet/placeOrder";
    private final static String USER_ORDERS_PAGE = "userCabinet/orders";
    private final static String USER_INVOICED_ORDERS_PAGE = "userCabinet/invoicedOrders";
    private final static String USER_ORDER_DETAILS_PAGE = "userCabinet/orderDetails";
    private final static String USER_MAIN_PAGE_REDIRECT = "redirect:/user";
    private final static String USER_INVOICED_ORDERS_REDIRECT = "redirect:/user/invoicedOrders";
    private final static String ATTRIBUTE_ORDER_DTO = "orderDTO";
    private final static String ATTRIBUTE_ORDER = "order";

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
        model.addAttribute(ATTRIBUTE_NAME, user.getName());
        return USER_MAIN_PAGE;
    }

    @GetMapping("/placeOrder")
    public String placeOrder(Model model)
            throws DatabaseFetchException {

        log.info("dispatchCitiesOptions: " + routeService.getCitiesOptions());

        model.addAttribute(ATTRIBUTE_ORDER_DTO, new OrderDTO());
        model.addAttribute(ATTRIBUTE_ROUTE_CITIES, routeService.getCitiesOptions());
        model.addAttribute(ATTRIBUTE_CARGO_TYPES, CargoType.values());

//        log.info("routeCities: " + routeCities);
//        log.info("cargoTypes: " + Arrays.toString(cargoTypes));
        return USER_PLACE_ORDER_PAGE;
    }

    @PostMapping("/placeOrder")
    public String addOrder(@ModelAttribute @Valid OrderDTO orderDTO,
                           BindingResult result,
                           Principal principal,
                           Model model)
            throws DatabaseFetchException, DatabaseSaveException {

//        log.info("inside UserController, inside addOrder() before validation");

        orderFormRegexValidator.validate(orderDTO, result);
        if (result.hasErrors()) {
            model.addAttribute(ATTRIBUTE_ROUTE_CITIES, routeService.getCitiesOptions());
            model.addAttribute(ATTRIBUTE_CARGO_TYPES, CargoType.values());
            return USER_PLACE_ORDER_PAGE;
        }

        log.info("OrderDTO created: " + orderDTO.toString());
        orderCreationService.addOrder(principal.getName(), orderDTO);
        return USER_MAIN_PAGE_REDIRECT;
    }

    @GetMapping("/orders")
    public String displayAllOrders(Principal principal, Model model)
            throws DatabaseFetchException {

        model.addAttribute(ATTRIBUTE_ORDERS, orderService.getOrdersByEmail(principal.getName()));
        return USER_ORDERS_PAGE;
    }

    @GetMapping("/invoicedOrders")
    public String displayOpenOrders(Principal principal, Model model)
            throws DatabaseFetchException {

        model.addAttribute(ATTRIBUTE_OPEN_ORDERS,
                orderService.getInvoicedOrdersByEmail(principal.getName()));
        return USER_INVOICED_ORDERS_PAGE;
    }

    @GetMapping("/invoicedOrders/{orderNumber}")
    public String displayOrderDetails(@PathVariable(PARAM_ORDER_NUMBER) Long orderNumber,
                                      Model model)
            throws DatabaseFetchException {

        model.addAttribute(ATTRIBUTE_ORDER, orderService.getOrderByNumber(orderNumber));
        return USER_ORDER_DETAILS_PAGE;
    }

    @PostMapping("/invoicedOrders/{orderNumber}")
    public String payOrder(@PathVariable(PARAM_ORDER_NUMBER) Long orderNumber)
            throws DatabaseFetchException, DatabaseSaveException {

        invoiceService.payInvoiceOfOrderNumber(orderNumber);
        return USER_INVOICED_ORDERS_REDIRECT;
    }

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseFetchException(DatabaseFetchException e, Model model) {
        model.addAttribute(ERROR_MESSAGE, e.toString());
        return GENERAL_ERROR_PAGE;
    }

    @ExceptionHandler(DatabaseSaveException.class)
    public String handleDatabaseSaveException(DatabaseSaveException e, Model model) {
        model.addAttribute(ERROR_MESSAGE, e.toString());
        return GENERAL_ERROR_PAGE;
    }
}
