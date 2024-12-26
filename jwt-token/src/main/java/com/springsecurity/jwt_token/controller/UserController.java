package com.springsecurity.jwt_token.controller;

import com.springsecurity.jwt_token.dto.CreateUserRequest;
import com.springsecurity.jwt_token.model.User;
import com.springsecurity.jwt_token.request.AuthRequest;
import com.springsecurity.jwt_token.service.JwtService;
import com.springsecurity.jwt_token.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello World! this is Furkan Türk";
    }

    @PostMapping("/addNewUser")
    public User addUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request){
        Authentication authentication= authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.username(),request.password()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(request.username());
        }
        Logger logger= LoggerFactory.getLogger(this.getClass());
        logger.info("Invalid username{}", request.username());
        throw new UsernameNotFoundException("Invalid username {}"+request.username());
    }

    @GetMapping("/user")
    public String getUserString(){
        return "This is user ";
    }

    @GetMapping("/admin")
    public String getAdminString(){
        return "This is admin";
    }

}
