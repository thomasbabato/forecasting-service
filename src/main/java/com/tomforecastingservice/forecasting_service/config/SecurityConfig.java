package com.tomforecastingservice.forecasting_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Configuration tells JSB that the class contains a @Bean definition
@Configuration
public class SecurityConfig {

    // For now it's fine this way since I want to access the homepage and the login page without auth
    // The SecurityFilterChain type tells spring security how to manage security. By Default it just locks everything behind a login page
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/login","/css/**","/webjars/**","/favicon.ico","/register").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
