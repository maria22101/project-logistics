package com.training.projectlogistics.service;

import com.training.projectlogistics.model.Invoice;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.repository.InvoiceRepository;
import com.training.projectlogistics.repository.OrderRepository;
import com.training.projectlogistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private InvoiceRepository invoiceRepository;

    @Autowired
    public AdminService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        InvoiceRepository invoiceRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.invoiceRepository = invoiceRepository;
    }

    //TODO - check for an empty result
    //TODO - how to get orders' sum?
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //TODO - check for an empty result
    //TODO - how to get orders' sum?
    public List<Order> getOpenOrders() {
        return orderRepository.findOrdersByOrderStatus(OrderStatus.OPEN);
    }

    //TODO - check for an empty result
    //TODO - how to get orders' sum?
    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findOrdersByUser(user);
    }

    @Transactional
    public void issueInvoice(Order order) {
        order.setOrderStatus(OrderStatus.INVOICED);
        orderRepository.save(order);
        invoiceRepository.save(new Invoice(order));
    }
}
