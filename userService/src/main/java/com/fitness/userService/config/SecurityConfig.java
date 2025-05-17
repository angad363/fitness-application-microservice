package com.fitness.userService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // For development/testing only
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register").permitAll()     // Allow POST /register
                        .requestMatchers(HttpMethod.GET, "/api/users/**").permitAll() // Allow GET /{userId}
                        .anyRequest().authenticated()                 // Secure everything else
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
