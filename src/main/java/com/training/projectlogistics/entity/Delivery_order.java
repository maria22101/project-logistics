package com.training.projectlogistics.entity;

import com.training.projectlogistics.entity.enums.Cargo;
import com.training.projectlogistics.entity.enums.Delivery_order_status;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "delivery_order")
public class Delivery_order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Digits(integer=5, fraction=2)
    @Column(name = "weight", nullable = false)
    private BigDecimal weight;

    @Column(name = "deliveryDate", nullable = false)
    private LocalDate deliveryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo", nullable = false)
    private Cargo cargo;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_route_id", referencedColumnName = "id")
    private Delivery_route delivery_route;

    @Digits(integer=5, fraction=2)
    @Column(name = "sum")
    private BigDecimal sum;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

//    @OneToOne(optional = true, cascade = CascadeType.ALL)
//    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "delivery_order")
    private Invoice invoice;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_order_status", nullable = false)
    private Delivery_order_status delivery_order_status;
}
