package com.training.projectlogistics.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return city.equals(address.city) &&
                street.equals(address.street) &&
                house.equals(address.house) &&
                Objects.equals(apartment, address.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, apartment);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
