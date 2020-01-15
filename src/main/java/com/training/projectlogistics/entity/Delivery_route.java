package com.training.projectlogistics.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "delivery_route")
public class Delivery_route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "deliveryCost", nullable = false)
    private Long cost;

    @OneToMany(mappedBy = "delivery_route")
    private List<Delivery_order> delivery_orders = new ArrayList<>();
}
