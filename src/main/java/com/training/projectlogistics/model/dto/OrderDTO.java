package com.training.projectlogistics.model.dto;

import com.training.projectlogistics.constants.TextConstants;
import com.training.projectlogistics.enums.CargoType;
import com.training.projectlogistics.model.validators.CargoTypeSubset;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

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
@Component
public class OrderDTO {
//    @NonNull
//    @NotEmpty
    private String dispatchCity;

//    @NonNull
//    @NotEmpty
    private String dispatchStreet;

//    @NonNull
//    @NotEmpty
    String dispatchHouse;

//    @NonNull
//    @NotEmpty
    String dispatchApartment;

//    @NonNull
//    @NotEmpty
    private String deliveryCity;

//    @NonNull
//    @NotEmpty
    private String deliveryStreet;

//    @NonNull
//    @NotEmpty
    String deliveryHouse;

//    @NonNull
//    @NotEmpty
    String deliveryApartment;

//    @NonNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate deliveryDate;

//    @DecimalMax("30.00")
//    @Column(precision=10, scale=2)

    // TODO - max value - property?

//    @NonNull
//    @NotEmpty
//    @DecimalMin(value = "0.00", inclusive = false)
//    @DecimalMax(value = "20.00", inclusive = true)
//    @Digits(integer=2, fraction=2)
    private BigDecimal weight;

//    @NotEmpty(message = TextConstants.ERROR_COMMENT_CARGO_TYPE)
    @CargoTypeSubset(anyOf = {CargoType.FRAGILE, CargoType.REGULAR}, message = TextConstants.ERROR_COMMENT_CARGO_TYPE)
    private CargoType cargoType;


}
