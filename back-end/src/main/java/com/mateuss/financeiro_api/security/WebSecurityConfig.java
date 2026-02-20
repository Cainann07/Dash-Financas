package com.mateuss.financeiro_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable) // Desliga o CORS temporariamente para evitar falsos positivos
                .csrf(AbstractHttpConfigurer::disable) // Desliga a proteção CSRF
                .authorizeHttpRequests(auth -> auth
                        // Vamos colocar as rotas separadas para o Spring não ter desculpa!
                        .requestMatchers("/usuarios/**").permitAll()
                        .requestMatchers("/gastos/**", "/gastos", "/gastos/*").permitAll() // 👈 Libera tudo de gastos explicitamente
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}