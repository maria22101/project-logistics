package com.training.projectlogistics.service;

import com.training.projectlogistics.model.Invoice;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.repository.InvoiceRepository;
import com.training.projectlogistics.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;
    private OrderRepository orderRepository;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          OrderRepository orderRepository) {
        this.invoiceRepository = invoiceRepository;
        this.orderRepository = orderRepository;
    }

    //TODO - split?
    @Transactional
    public void payInvoiceOfOrderNumber(Long orderNumber) {
        Invoice invoice = invoiceRepository.findByOrder_OrderNumber(orderNumber).get();
        invoice.setPaid(true);

        Order order = orderRepository.findOrderByOrderNumber(orderNumber).get();
        order.setOrderStatus(OrderStatus.READY_FOR_DISPATCH);

        invoiceRepository.save(invoice);
        orderRepository.save(order);
    }
}
