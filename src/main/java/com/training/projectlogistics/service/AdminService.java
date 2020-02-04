package com.training.projectlogistics.service;

import com.training.projectlogistics.model.Invoice;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminService {
    private OrderRepository orderRepository;
    private InvoiceRepository invoiceRepository;

    @Autowired
    public AdminService(OrderRepository orderRepository,
                        InvoiceRepository invoiceRepository) {
        this.orderRepository = orderRepository;
        this.invoiceRepository = invoiceRepository;
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
