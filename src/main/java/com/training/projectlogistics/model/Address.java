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
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house", nullable = false)
    private String house;

    @Column(name = "apartment")
    private String apartment;

    @OneToMany(mappedBy = "dispatchAddress", fetch = FetchType.LAZY)
    private List<Order> dispatchingOrders = new ArrayList<>();

    @OneToMany(mappedBy = "deliveryAddress", fetch = FetchType.LAZY)
    private List<Order> deliveringOrders = new ArrayList<>();

    public Address(String street, String house, String apartment) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }
}
