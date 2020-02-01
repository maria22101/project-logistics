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
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "source")
    private String source;

    @Column(name = "source_ua", nullable = false)
    private String sourceUA;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "destination_ua")
    private String destinationUA;

    @Column(name = "basic_rate", nullable = false)
    private BigDecimal basicRate;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();
}
