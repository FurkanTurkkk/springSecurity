package com.furkanturk.security.basic_auth.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_MOD("MOD");

    private String value;

    Role(String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
