package com.training.projectlogistics.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
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
public class DeliveryRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "basic_rate", nullable = false)
    private BigDecimal basicRate;

    @OneToMany(mappedBy = "delivery_route", fetch = FetchType.EAGER)
    private List<DeliveryOrder> delivery_orders = new ArrayList<>();
}
