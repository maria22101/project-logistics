package com.training.projectlogistics.service;

import com.training.projectlogistics.model.Invoice;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.Route;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.model.enums.Role;
import com.training.projectlogistics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private OrderRepository orderRepository;
    private InvoiceRepository invoiceRepository;
    private RouteRepository routeRepository;

    @Autowired
    public AdminService(OrderRepository orderRepository,
                        InvoiceRepository invoiceRepository,
                        RouteRepository routeRepository) {
        this.orderRepository = orderRepository;
        this.invoiceRepository = invoiceRepository;
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    //TODO - split?
    @Transactional
    public void issueInvoice(Order order) {
        order.setOrderStatus(OrderStatus.INVOICED);
        Invoice invoice = new Invoice(order);

        orderRepository.save(order);
        invoiceRepository.save(invoice);
    }
}
