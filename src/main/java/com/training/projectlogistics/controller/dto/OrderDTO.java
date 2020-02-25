package com.training.projectlogistics.controller.dto;

import com.training.projectlogistics.controller.validation.WeightRange;
import com.training.projectlogistics.enums.CargoType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderDTO {
    @NotEmpty
    private String dispatchCity;

    @NotEmpty
    private String dispatchStreet;

    @NotEmpty
    private String dispatchHouse;

    private String dispatchApartment;

    @NotEmpty
    private String deliveryCity;

    @NotEmpty
    private String deliveryStreet;

    @NotEmpty
    private String deliveryHouse;

    private String deliveryApartment;

    @Future
    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate deliveryDate;

    @NotNull
    @Digits(integer=2, fraction=2)
    @WeightRange
    private BigDecimal weight;

    @NotNull
    private CargoType cargoType;
}
