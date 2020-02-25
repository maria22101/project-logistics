package com.training.projectlogistics.model;

import com.training.projectlogistics.enums.CargoType;
import com.training.projectlogistics.enums.OrderStatus;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

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

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @DecimalMin(value = "0.00", inclusive = false)
    @DecimalMax(value = "20.00", inclusive = true)
    @Digits(integer=2, fraction=2)
    @Column(name = "weight", nullable = false)
    private BigDecimal weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_type", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return user.equals(order.user) &&
                dispatchAddress.equals(order.dispatchAddress) &&
                deliveryAddress.equals(order.deliveryAddress) &&
                deliveryDate.equals(order.deliveryDate) &&
                weight.equals(order.weight) &&
                cargoType == order.cargoType &&
                sum.equals(order.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, dispatchAddress, deliveryAddress, deliveryDate, weight, cargoType, sum);
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", dispatchAddress=" + dispatchAddress +
                ", deliveryAddress=" + deliveryAddress +
                ", deliveryDate=" + deliveryDate +
                ", weight=" + weight +
                ", cargoType=" + cargoType +
                ", sum=" + sum +
                ", orderStatus=" + orderStatus +
                ", route=" + route +
                ", invoice=" + invoice +
                '}';
    }
}
