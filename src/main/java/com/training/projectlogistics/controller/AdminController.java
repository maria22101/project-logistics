package com.training.projectlogistics.controller;

import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.exceptions.DatabaseSaveException;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.enums.Role;
import com.training.projectlogistics.service.AdminService;
import com.training.projectlogistics.service.OrderService;
import com.training.projectlogistics.service.RouteService;
import com.training.projectlogistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private UserService userService;
    private AdminService adminService;
    private OrderService orderService;
    private RouteService routeService;

    @Autowired
    public AdminController(UserService userService,
                           AdminService adminService,
                           OrderService orderService,
                           RouteService routeService) {
        this.userService = userService;
        this.adminService = adminService;
        this.orderService = orderService;
        this.routeService = routeService;
    }

    @GetMapping
    public String greetAdmin(Model model) {
        return "adminCabinet/adminMain";
    }

    @GetMapping("/orders")
    public String displayAllOrders(Model model)
            throws DatabaseFetchException {

        model.addAttribute("orders", orderService.getAllOrders());

        return "adminCabinet/orders";
    }

    @GetMapping("/open_orders")
    public String displayOpenOrders(Model model)
            throws DatabaseFetchException {

        model.addAttribute("openOrders", orderService.getOpenOrders());

        return "adminCabinet/openOrders";
    }

    @PostMapping("/open_orders")
    public String issueInvoice(@RequestParam("orderNumber") Long orderNumber)
            throws DatabaseFetchException, DatabaseSaveException {

        Order editingOrder = orderService.getOrderByNumber(orderNumber);
        adminService.issueInvoice(editingOrder);

        return "redirect:/admin/open_orders";
    }

    @GetMapping("/users")
    public String displayUsers(Model model)
            throws DatabaseFetchException {

        model.addAttribute("users", adminService.getUsersByRole(Role.USER));

        return "adminCabinet/users";
    }

    @GetMapping("/routes")
    public String displayRoutes(Model model)
            throws DatabaseFetchException {

        model.addAttribute("routes", routeService.getAllRoutes());

        return "adminCabinet/routes";
    }

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseIssueException(DatabaseFetchException e, Model model) {
        model.addAttribute("errorMessage", e.toString());

        return "general/error";
    }

    @ExceptionHandler(DatabaseSaveException.class)
    public String handleDatabaseSaveException(DatabaseSaveException e, Model model) {
        model.addAttribute("errorMessage", e.toString());

        return "general/error";
    }
}
