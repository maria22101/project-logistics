package com.training.projectlogistics.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return pointOne.equals(route.pointOne) &&
                pointOneUA.equals(route.pointOneUA) &&
                pointTwo.equals(route.pointTwo) &&
                pointTwoUA.equals(route.pointTwoUA) &&
                basicRate.equals(route.basicRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointOne, pointOneUA, pointTwo, pointTwoUA, basicRate);
    }

    @Override
    public String toString() {
        return "Route{" +
                "pointOne='" + pointOne + '\'' +
                ", pointOneUA='" + pointOneUA + '\'' +
                ", pointTwo='" + pointTwo + '\'' +
                ", pointTwoUA='" + pointTwoUA + '\'' +
                ", basicRate=" + basicRate +
                '}';
    }
}
