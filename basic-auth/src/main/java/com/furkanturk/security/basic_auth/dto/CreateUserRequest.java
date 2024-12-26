package com.furkanturk.security.basic_auth.dto;


import com.furkanturk.security.basic_auth.model.Role;

import java.util.Set;

public record CreateUserRequest(
       String name,
       String username,
       String password,
       Set<Role> roles
) {
}
