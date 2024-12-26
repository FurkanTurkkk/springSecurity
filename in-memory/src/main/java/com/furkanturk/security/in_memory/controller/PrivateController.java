package com.furkanturk.security.in_memory.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {
    @GetMapping
    public String helloWorld(){
        return "Hello world from private endpoint";
    }

    @GetMapping("/user")
    public String helloWorldUser(){
        return "Hello world from private endpoint for user";
    }

    @GetMapping("/admin")
    public String helloWorldAdmin(){
        return "Hello world from private endpoint for admin";
    }
}
