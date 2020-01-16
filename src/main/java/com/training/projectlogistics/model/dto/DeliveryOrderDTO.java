package com.training.projectlogistics.model.dto;

import com.training.projectlogistics.model.enums.Cargo;
import lombok.*;

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
    private BigDecimal weight;

    @NonNull
    @NotEmpty
    private Cargo cargo;
}
