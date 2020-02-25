package com.training.projectlogistics.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "invoices",
        uniqueConstraints={@UniqueConstraint(columnNames = "order_number",
                name = "uniqueOrderNumberConstraint")})
public class Invoice{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_number", nullable = false)
    private Long invoiceNumber;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_number", referencedColumnName = "order_number", unique = true)
    private Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return isPaid == invoice.isPaid &&
                invoiceNumber.equals(invoice.invoiceNumber) &&
                order.equals(invoice.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceNumber, isPaid, order);
    }
}
