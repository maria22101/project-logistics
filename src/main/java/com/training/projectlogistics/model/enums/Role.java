package com.training.projectlogistics.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    GUEST;

    @Override
    public String getAuthority() {
        return name();
    }
}
