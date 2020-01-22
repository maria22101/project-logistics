package com.training.projectlogistics.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "invoice",
        uniqueConstraints={@UniqueConstraint(columnNames = "delivery_order_number",
                name = "uniqueOrderNumberConstraint")})
public class Invoice{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_number", nullable = false)
    private Long invoiceNumber;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_order_number", referencedColumnName = "order_number", unique = true)
    private Order order;

    public Invoice(Order order) {
        this.order = order;
    }
}
