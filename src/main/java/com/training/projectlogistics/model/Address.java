package com.training.projectlogistics.model;

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
@Table(name = "delivery_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "street")
    String street;

    @Column(name = "house")
    String house;

    @Column(name = "apartment")
    String apartment;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    public Address(String street, String house, String apartment, Route route) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.route = route;
    }
}
