package com.training.projectlogistics.entity;

import com.training.projectlogistics.entity.enums.WeightCategory;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "weight_input")
public class Weight_input {
    @Id
    @Enumerated(EnumType.STRING)
    private WeightCategory weightCategory;

    @Digits(integer=5, fraction=2)
    @Column(name = "rangeFrom", nullable = false)
    private BigDecimal rangeFrom;

    @Digits(integer=5, fraction=2)
    @Column(name = "rangeTo", nullable = false)
    private BigDecimal rangeTo;

    @Digits(integer=5, fraction=2)
    @Column(name = "weight_coefficient", nullable = true)
    private BigDecimal weightCoefficient;
}
