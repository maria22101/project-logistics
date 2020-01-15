package com.training.projectlogistics.entity;

import com.training.projectlogistics.entity.enums.Cargo;
import com.training.projectlogistics.entity.enums.Delivery_order_status;
import lombok.*;

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
public class Delivery_order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "weight", nullable = false)
    private Long weight;

    @Column(name = "deliveryDate", nullable = false)
    private LocalDate deliveryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo", nullable = false)
    private Cargo cargo;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_route_id", referencedColumnName = "id")
    private Delivery_route delivery_route;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

//    @OneToOne(optional = true, cascade = CascadeType.ALL)
//    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @OneToOne(mappedBy = "delivery_order", cascade = CascadeType.ALL)
    private Invoice invoice;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_order_status", nullable = false)
    private Delivery_order_status delivery_order_status;
}
