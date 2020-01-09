package com.training.projectlogistics.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    boolean isPaid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_order_id", referencedColumnName = "id")
    Delivery_order delivery_order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
