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
@Table(name = "delivery_item")
public class DeliveryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "deliveryItem", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "weight_category", referencedColumnName = "weight_category")
    WeightRate weightRate;
}
