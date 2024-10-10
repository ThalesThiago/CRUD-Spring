package org.sebastiandev.crudspring.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Crud api Marcio")
                        .version("1.0")
                        .description("Atividade de relacionamentos de entidades marcio"));
    }
}