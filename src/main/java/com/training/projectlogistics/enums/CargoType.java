package com.training.projectlogistics.enums;
import java.util.Locale;

import static com.training.projectlogistics.constants.TextConstants.*;

public enum CargoType {
    REGULAR(CARGO_REGULAR),
    FRAGILE(CARGO_FRAGILE);

    private final String description;

    CargoType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
