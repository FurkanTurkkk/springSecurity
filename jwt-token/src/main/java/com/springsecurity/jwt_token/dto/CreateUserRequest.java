package com.springsecurity.jwt_token.dto;




import com.springsecurity.jwt_token.model.Role;

import java.util.Set;

public record CreateUserRequest(
       String name,
       String username,
       String password,
       Set<Role> roles
) {
}
