package com.training.projectlogistics.service;

import com.training.projectlogistics.model.Invoice;
import com.training.projectlogistics.model.Order;
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
    private UserRepository userRepository;
    private InvoiceRepository invoiceRepository;
    private RouteRepository routeRepository;
    private WeightRateRepository weightRateRepository;

    @Autowired
    public AdminService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        InvoiceRepository invoiceRepository,
                        RouteRepository routeRepository,
                        WeightRateRepository weightRateRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.invoiceRepository = invoiceRepository;
        this.routeRepository = routeRepository;
        this.weightRateRepository = weightRateRepository;
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
