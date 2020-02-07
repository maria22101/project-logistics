package com.training.projectlogistics.constants;

import java.util.ResourceBundle;

public class BusinessInputConstants {
    public static final String WEIGHT_LIGHT_LOWER_BOUND;
    public static final String WEIGHT_LIGHT_UPPER_BOUND;
    public static final String WEIGHT_MEDIUM_LOWER_BOUND;
    public static final String WEIGHT_MEDIUM_UPPER_BOUND;
    public static final String WEIGHT_HEAVY_LOWER_BOUND;
    public static final String WEIGHT_HEAVY_UPPER_BOUND;

    public static final String WEIGHT_LIGHT_COEFFICIENT;
    public static final String WEIGHT_MEDIUM_COEFFICIENT;
    public static final String WEIGHT_HEAVY_COEFFICIENT;

    static{
        ResourceBundle rb = ResourceBundle.getBundle("business_input");

        WEIGHT_LIGHT_LOWER_BOUND = rb.getString("weight.light.lower.bound.value");
        WEIGHT_LIGHT_UPPER_BOUND = rb.getString("weight.light.upper.bound.value");
        WEIGHT_MEDIUM_LOWER_BOUND = rb.getString("weight.medium.lower.bound.value");
        WEIGHT_MEDIUM_UPPER_BOUND = rb.getString("weight.medium.upper.bound.value");
        WEIGHT_HEAVY_LOWER_BOUND = rb.getString("weight.heavy.lower.bound.value");
        WEIGHT_HEAVY_UPPER_BOUND = rb.getString("weight.heavy.upper.bound.value");

        WEIGHT_LIGHT_COEFFICIENT = rb.getString("weight.coeff.light");
        WEIGHT_MEDIUM_COEFFICIENT = rb.getString("weight.coeff.medium");
        WEIGHT_HEAVY_COEFFICIENT = rb.getString("weight.coeff.heavy");
    }
}
