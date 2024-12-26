package com.furkanturk.security.in_memory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //SecurityFilterChain için eklenen anotasyon
@EnableMethodSecurity //Controller sınıfına security etmek için kullanılan anotasyon
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users(){
        UserDetails user1= User.builder()
                .username("furkan")
                .password(passwordEncoder().encode("123321"))
                .roles("USER")
                .build();
        UserDetails user2=User.builder()
                .username("fatih")
                .password(passwordEncoder().encode("123321"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
        security
                .headers(t->t.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(t->t.requestMatchers("/public/**","/auth/**").permitAll())
                .authorizeHttpRequests(t->t.requestMatchers("/private/user/**").hasRole("USER"))
                .authorizeHttpRequests(t->t.requestMatchers("/private/admin/**").hasRole("ADMIN"))
                .authorizeHttpRequests(t->t.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return security.build();
    }
}
