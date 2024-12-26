package com.springsecurity.jwt_token.service;

import com.springsecurity.jwt_token.dto.CreateUserRequest;
import com.springsecurity.jwt_token.model.User;
import com.springsecurity.jwt_token.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByUsername(username);
        return user.orElseThrow(EntityExistsException::new);
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
        if(userRepository.findByUsername(newUser.getUsername()).isPresent()){
            throw new IllegalArgumentException("User exist by this username");
        }
        return userRepository.save(newUser);
    }
}
