package com.training.projectlogistics.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "weight_rate")
public class WeightRate {
    @Id
//    @Enumerated(EnumType.STRING)
    @Column(name = "weight_category")
    private String weightCategory;

    @Digits(integer=5, fraction=2)
    @Column(name = "weight_from", nullable = false)
    private BigDecimal weightFrom;

    @Digits(integer=5, fraction=2)
    @Column(name = "weight_to", nullable = false)
    private BigDecimal weightTo;

    @Digits(integer=5, fraction=2)
    @Column(name = "weight_coefficient", nullable = true)
    private BigDecimal weightCoefficient;

    @OneToMany(mappedBy = "weightRate", fetch = FetchType.EAGER)
    private List<DeliveryItem> deliveryItems = new ArrayList<>();
}
