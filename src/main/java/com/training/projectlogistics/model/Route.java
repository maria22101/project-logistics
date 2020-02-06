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
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "point_one")
    private String pointOne;

    @Column(name = "point_one_ua", nullable = false)
    private String pointOneUA;

    @Column(name = "point_two", nullable = false)
    private String pointTwo;

    @Column(name = "point_two_ua")
    private String pointTwoUA;

    @Column(name = "basic_rate", nullable = false)
    private BigDecimal basicRate;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
}
