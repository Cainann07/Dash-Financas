package com.mateuss.financeiro_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI financeiroOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Financeiro API")
                        .description("API para controle de gastos pessoais - Desafio Back-end")
                        .version("v1.0.0"));
    }
}
