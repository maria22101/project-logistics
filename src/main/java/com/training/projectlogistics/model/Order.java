package com.training.projectlogistics.model;

import com.training.projectlogistics.enums.CargoType;
import com.training.projectlogistics.enums.OrderStatus;
import com.training.projectlogistics.model.validators.CargoTypeSubset;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "dispatch_address_id", referencedColumnName = "id")
    private Address dispatchAddress;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_address_id", referencedColumnName = "id")
    private Address deliveryAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "20.0", inclusive = true)
    @Digits(integer=2, fraction=2)
    @Column(name = "weight", nullable = false)
    private BigDecimal weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_type", nullable = false)
    @CargoTypeSubset(anyOf = {CargoType.FRAGILE, CargoType.REGULAR})
    private CargoType cargoType;

    @Column(name = "sum", nullable = false)
    private BigDecimal sum;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "order")
    private Invoice invoice;
}
