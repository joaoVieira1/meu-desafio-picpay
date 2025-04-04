package com.myproject.desafio_picpay_backend.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        return http
                .csrf(csfr -> csfr.disable())
                .httpBasic(Customizer.withDefaults())
                .formLogin(form -> form.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest()
                        .permitAll()
                )
                .formLogin(withDefaults())
                .build();
    }

}
