package com.training.projectlogistics.controller.dto;

import com.training.projectlogistics.controller.validation.WeightRange;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CalculatorDTO {
    private String dispatchCity;
    private String deliveryCity;

    @NotNull
    @Digits(integer=2, fraction=2)
    @WeightRange
    private BigDecimal weight;
}
