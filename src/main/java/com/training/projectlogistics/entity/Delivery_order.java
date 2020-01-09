package com.training.projectlogistics.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "delivery_order")
public class Delivery_order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long weight;
    private Date deliveryDate;

    @Enumerated(EnumType.STRING)
    private Delivery_order_status delivery_order_status;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_route_id", referencedColumnName = "id")
    private Delivery_route delivery_route;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
