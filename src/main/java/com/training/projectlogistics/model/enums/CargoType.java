package com.training.projectlogistics.model.enums;

public enum CargoType {
    REGULAR("REGULAR"),
    FRAGILE("FRAGILE");

    private final String description;

    private CargoType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
