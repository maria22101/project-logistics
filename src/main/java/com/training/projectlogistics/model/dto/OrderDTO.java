package com.training.projectlogistics.model.dto;

import com.training.projectlogistics.model.enums.CargoType;
import com.training.projectlogistics.model.validators.CargoTypeSubset;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderDTO {
    @NonNull
    @NotEmpty
    private String source;

    @NonNull
    @NotEmpty
    private String destination;

    @NonNull
    @NotEmpty
    String street;

    @NonNull
    @NotEmpty
    String house;

    @NonNull
    @NotEmpty
    String apartment;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

//    @NonNull
//    @NotEmpty
//    @DecimalMax("30.00")
//    @Column(precision=10, scale=2)

    // TODO - max value - property?
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "20.0", inclusive = true)
    @Digits(integer=2, fraction=2)
    private BigDecimal weight;

    @NonNull
    @NotEmpty
    @CargoTypeSubset(anyOf = {CargoType.FRAGILE, CargoType.REGULAR})
    private CargoType cargoType;
}
