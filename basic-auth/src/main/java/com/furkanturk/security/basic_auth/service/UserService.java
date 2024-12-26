package com.furkanturk.security.basic_auth.service;

import com.furkanturk.security.basic_auth.dto.CreateUserRequest;
import com.furkanturk.security.basic_auth.model.User;
import com.furkanturk.security.basic_auth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequest request){
        User newUser = new User(
                request.name(),
                request.username(),
                passwordEncoder.encode(request.password()),
                true,
                true,
                true,
                true,
                request.roles()
        );

        return userRepository.save(newUser);
    }
}
