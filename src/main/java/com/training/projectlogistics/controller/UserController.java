package com.training.projectlogistics.controller;

import com.training.projectlogistics.controller.unility.OrderAddressDTOValidator;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.dto.OrderAddressDTO;
import com.training.projectlogistics.model.enums.CargoType;
import com.training.projectlogistics.model.validators.CargoTypeEnumValidator;
import com.training.projectlogistics.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

import static com.training.projectlogistics.controller.TextConstants.DATABASE_ISSUE;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    private OrderCreationService orderCreationService;
    private OrderService orderService;
    private InvoiceService invoiceService;
    private OrderAddressDTOValidator orderAddressDTOValidator;
    private CargoTypeEnumValidator cargoTypeEnumValidator;

    @Autowired
    public UserController(OrderCreationService orderCreationService,
                          OrderService orderService,
                          InvoiceService invoiceService,
                          OrderAddressDTOValidator orderAddressDTOValidator,
                          CargoTypeEnumValidator cargoTypeEnumValidator) {
        this.orderCreationService = orderCreationService;
        this.orderService = orderService;
        this.invoiceService = invoiceService;
        this.cargoTypeEnumValidator = cargoTypeEnumValidator;
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
        model.addAttribute("orderAddressDTO", new OrderAddressDTO());
        model.addAttribute("cargoTypes", CargoType.values());
        return "userCabinet/placeOrder";
    }

    @PostMapping("/placeOrder")
    public String addOrder(@ModelAttribute("orderDTO") @Valid OrderAddressDTO orderAddressDTO,
                           BindingResult result,
                           Principal principal)
            throws DatabaseIssueException {

        orderAddressDTOValidator.validate(orderAddressDTO, result);
        if (result.hasErrors()) {
            return "userCabinet/placeOrder";
        }

        orderCreationService.addOrder(principal.getName(), orderAddressDTO);

        return "redirect:/user";
    }

    @ExceptionHandler(DatabaseIssueException.class)
    public String handleDatabaseIssueException(DatabaseIssueException ex,
                                               Model model) {
        model.addAttribute("errorMessage", DATABASE_ISSUE);

        return "general/error";
    }
}
