package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Invoice;
import com.training.projectlogistics.model.Order;
import com.training.projectlogistics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findByInvoiceNumber(Long invoiceNumber);
    Optional<Invoice> findByOrder_OrderNumber(Long orderNumber);
    Optional<Invoice> findByOrder(Order order);

}
