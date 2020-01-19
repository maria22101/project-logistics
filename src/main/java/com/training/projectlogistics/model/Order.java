package com.training.projectlogistics.model;

import com.training.projectlogistics.model.enums.OrderStatus;
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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delivery_order_number", nullable = false)
    private Long orderNumber;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_item_id", referencedColumnName = "id")
    private DeliveryItem deliveryItem;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(mappedBy = "order")
    private Invoice invoice;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_order_status", nullable = false)
    private OrderStatus orderStatus;
}
