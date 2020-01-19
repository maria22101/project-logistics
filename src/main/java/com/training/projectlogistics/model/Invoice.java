package com.training.projectlogistics.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "invoice",
        uniqueConstraints={@UniqueConstraint(columnNames={"delivery_order_number"})})
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_number")
    private Long invoiceNumber;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_order_number", referencedColumnName = "delivery_order_number", unique=true)
    private Order order;
}
