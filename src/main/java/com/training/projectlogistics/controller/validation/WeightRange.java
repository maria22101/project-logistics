package com.training.projectlogistics.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WeightRangeConstraintValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface WeightRange {

    String message() default "{WeightRange to be followed}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
