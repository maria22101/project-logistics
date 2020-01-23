package com.training.projectlogistics.model;

import com.training.projectlogistics.model.enums.CargoType;
import com.training.projectlogistics.model.enums.OrderStatus;
import com.training.projectlogistics.model.validators.CargoTypeSubset;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "delivery_order")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "weight_category", referencedColumnName = "weight_category")
    private WeightRate weightRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_type", nullable = false)
    @CargoTypeSubset(anyOf = {CargoType.FRAGILE, CargoType.REGULAR})
    private CargoType cargoType;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "order")
    private Invoice invoice;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;
}
