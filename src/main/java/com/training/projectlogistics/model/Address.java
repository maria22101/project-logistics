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

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public Address(String street, String house, String appartment) {
        this.street = street;
        this.house = house;
        this.apartment = appartment;
    }
}
