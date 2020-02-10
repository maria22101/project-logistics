package com.training.projectlogistics.service;

import com.training.projectlogistics.enums.Role;
import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.exceptions.DatabaseSaveException;
import com.training.projectlogistics.model.Invoice;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.enums.OrderStatus;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    private OrderRepository orderRepository;
    private InvoiceRepository invoiceRepository;
    private UserRepository userRepository;

    @Autowired
    public AdminService(OrderRepository orderRepository,
                        InvoiceRepository invoiceRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void issueInvoice(Order order) throws DatabaseSaveException {

        order.setOrderStatus(OrderStatus.INVOICED);
        Invoice invoice = new Invoice(order);
        try {
            orderRepository.save(order);
            invoiceRepository.save(invoice);
        } catch (Exception e) {
            throw new DatabaseSaveException();
        }
    }

    public List<User> getUsersByRole(Role role)
            throws DatabaseFetchException {

        try {
            return userRepository.findUsersByRole(role);
        } catch (Exception e) {
            throw new DatabaseFetchException();
        }
    }
}
