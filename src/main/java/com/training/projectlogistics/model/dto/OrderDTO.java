package com.training.projectlogistics.model.dto;

import com.training.projectlogistics.enums.CargoType;
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
    private String dispatchCity;

    @NonNull
    @NotEmpty
    private String dispatchStreet;

    @NonNull
    @NotEmpty
    String dispatchHouse;

    @NonNull
    @NotEmpty
    String dispatchApartment;

    @NonNull
    @NotEmpty
    private String deliveryCity;

    @NonNull
    @NotEmpty
    private String deliveryStreet;

    @NonNull
    @NotEmpty
    String deliveryHouse;

    @NonNull
    @NotEmpty
    String deliveryApartment;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

//    @DecimalMax("30.00")
//    @Column(precision=10, scale=2)

    // TODO - max value - property?

    @NonNull
    @NotEmpty
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "20.0", inclusive = true)
    @Digits(integer=2, fraction=2)
    private BigDecimal weight;

    @CargoTypeSubset(anyOf = {CargoType.FRAGILE, CargoType.REGULAR})
    private CargoType cargoType;
}
