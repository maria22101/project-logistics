package com.training.projectlogistics.model;

import com.training.projectlogistics.model.enums.Cargo;
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
@Table(name = "cargo_input")
public class Cargo_input {
    @Id
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Digits(integer=5, fraction=2)
    @Column(name = "cargo_coefficient", nullable = true)
    private BigDecimal cargoCoefficient;
}
