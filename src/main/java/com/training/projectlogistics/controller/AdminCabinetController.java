package com.training.projectlogistics.controller;

import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.enums.Role;
import com.training.projectlogistics.service.AdminService;
import com.training.projectlogistics.service.OrderService;
import com.training.projectlogistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasAuthority('ADMIN')")
public class AdminCabinetController {
    private UserService userService;
    private AdminService adminService;
    private OrderService orderService;

    @Autowired
    public AdminCabinetController(UserService userService,
                                  AdminService adminService,
                                  OrderService orderService) {
        this.userService = userService;
        this.adminService = adminService;
        this.orderService = orderService;
    }

    @GetMapping
    public String greetAdmin(Model model) {
        return "adminCabinet/adminMain";
    }

//    @GetMapping("/orders")
//    public String displayOrders(Model model) {
//        model.addAttribute("orders", adminService.getAllOrders());
//
//        return "adminCabinet/orderList";
//    }

    @GetMapping("/orders")
    public String displayAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());

        return "adminCabinet/orders";
    }

    @GetMapping("/openOrders")
    public String displayOpenOrders(Model model) {
        model.addAttribute("openOrders", orderService.getOpenOrders());

        return "adminCabinet/openOrders";
    }

//    @GetMapping("/orders/{orderNumber}")
//    public String orderStatusChange(@PathVariable("orderNumber") Long orderNumber, Model model) {
//        model.addAttribute("order", orderService.getOrderByNumber(orderNumber));
//        model.addAttribute("statuses", OrderStatus.values());
//
//        return "adminCabinet/orderEdit";
//    }

    @PostMapping("/openOrders")
    public String displayEditedOrders(@RequestParam("orderNumber") Long orderNumber) {
        Order editingOrder = orderService.getOrderByNumber(orderNumber);
        adminService.issueInvoice(editingOrder);

        return "redirect:/admin/orders";
    }

    @GetMapping("/users")
    public String displayUsers(Model model) {
        model.addAttribute("users", userService.getUsersByRole(Role.USER));

        return "adminCabinet/userList";
    }
}
