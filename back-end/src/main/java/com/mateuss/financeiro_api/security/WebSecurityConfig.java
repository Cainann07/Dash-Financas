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

    // 1. O Bean que faz a criptografia (Magic happens here) 🪄
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Configuração de rotas (Liberando tudo por enquanto para testes) 🚦
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desabilita CSRF para facilitar API
                .authorizeHttpRequests(auth -> auth
                        // Libera o cadastro de usuários e o Swagger para você testar
                        .requestMatchers("/usuarios/**", "/usuarios/login" , "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        // Qualquer outra coisa precisa de autenticação (quando fizermos o login)
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}