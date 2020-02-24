package com.training.projectlogistics.controller;

import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.exceptions.DatabaseSaveException;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.enums.Role;
import com.training.projectlogistics.service.AdminService;
import com.training.projectlogistics.service.OrderService;
import com.training.projectlogistics.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.training.projectlogistics.constants.WebConstants.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final static String ADMIN_CABINET_PATH = "adminCabinet/adminMain";
    private final static String ADMIN_CABINET_ORDERS_PATH = "adminCabinet/orders";
    private final static String ADMIN_CABINET_OPEN_ORDERS_PATH = "adminCabinet/openOrders";
    private final static String ADMIN_CABINET_OPEN_ORDERS_REDIRECT = "redirect:/admin/open_orders";
    private final static String ADMIN_CABINET_USERS_PATH = "adminCabinet/users";
    private final static String ADMIN_CABINET_ROUTES_PATH = "adminCabinet/routes";

    private AdminService adminService;
    private OrderService orderService;
    private RouteService routeService;

    @Autowired
    public AdminController(AdminService adminService,
                           OrderService orderService,
                           RouteService routeService) {
        this.adminService = adminService;
        this.orderService = orderService;
        this.routeService = routeService;
    }

    @GetMapping
    public String greetAdmin() {
        return ADMIN_CABINET_PATH;
    }

    @GetMapping("/orders")
    public String displayAllOrders(Model model)
            throws DatabaseFetchException {

        model.addAttribute(ATTRIBUTE_ORDERS, orderService.getAllOrders());
        return ADMIN_CABINET_ORDERS_PATH;
    }

    @GetMapping("/open_orders")
    public String displayOpenOrders(Model model)
            throws DatabaseFetchException {

        model.addAttribute(ATTRIBUTE_OPEN_ORDERS, orderService.getOpenOrders());
        return ADMIN_CABINET_OPEN_ORDERS_PATH;
    }

    @PostMapping("/open_orders")
    public String issueInvoice(@RequestParam(PARAM_ORDER_NUMBER) Long orderNumber)
            throws DatabaseFetchException, DatabaseSaveException {

        Order editingOrder = orderService.getOrderByNumber(orderNumber);
        adminService.issueInvoice(editingOrder);
        return ADMIN_CABINET_OPEN_ORDERS_REDIRECT;
    }

    @GetMapping("/users")
    public String displayUsers(Model model)
            throws DatabaseFetchException {

        model.addAttribute(ATTRIBUTE_USERS, adminService.getUsersByRole(Role.USER));
        return ADMIN_CABINET_USERS_PATH;
    }

    @GetMapping("/routes")
    public String displayRoutes(Model model)
            throws DatabaseFetchException {

        model.addAttribute(ATTRIBUTE_ROUTES, routeService.getAllRoutes());
        return ADMIN_CABINET_ROUTES_PATH;
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
