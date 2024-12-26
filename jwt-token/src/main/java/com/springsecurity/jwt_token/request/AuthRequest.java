package com.springsecurity.jwt_token.request;

public record AuthRequest(
        String username,
        String password
) {
}
