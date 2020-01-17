package com.training.projectlogistics.model.dto;

import com.training.projectlogistics.model.enums.Cargo;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeliveryOrderDTO {
    @NonNull
    @NotEmpty
    private String source;

    @NonNull
    @NotEmpty
    private String destination;

    @NonNull
    @NotEmpty
    private LocalDate deliveryDate;

    @NonNull
    @NotEmpty
    @DecimalMax("30.00")
//    @Column(precision=10, scale=2)
    private BigDecimal weight;

    @NonNull
    @NotEmpty
    private Cargo cargo;
}
