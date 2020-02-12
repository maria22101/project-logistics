package com.training.projectlogistics.service;

import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.exceptions.DatabaseSaveException;
import com.training.projectlogistics.model.Invoice;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.enums.OrderStatus;
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

    @Transactional
    public void payInvoiceOfOrderNumber(Long orderNumber)
            throws DatabaseFetchException, DatabaseSaveException {

        Invoice invoice = invoiceRepository.findByOrder_OrderNumber(orderNumber)
                .orElseThrow(DatabaseFetchException::new);

        invoice.setPaid(true);

        Order order = orderRepository.findOrderByOrderNumber(orderNumber)
                .orElseThrow(DatabaseFetchException::new);

        order.setOrderStatus(OrderStatus.READY_FOR_DISPATCH);

        try {
            invoiceRepository.save(invoice);
            orderRepository.save(order);
        } catch (Exception e) {
            throw new DatabaseSaveException();
        }
    }
}
