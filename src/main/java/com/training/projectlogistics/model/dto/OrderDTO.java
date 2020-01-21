package com.training.projectlogistics.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

//    @NonNull
//    @NotEmpty
//    @DecimalMax("30.00")
//    @Column(precision=10, scale=2)

    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMin(value = "20.0", inclusive = false)
    @Digits(integer=2, fraction=2)
    private BigDecimal weight;
}
