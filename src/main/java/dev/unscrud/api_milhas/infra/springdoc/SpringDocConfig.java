package dev.unscrud.api_milhas.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(
                new Components().addSecuritySchemes(
                    "bearer-key",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                )
            )
            .info(
                new Info()
                    .title("Jornada Milhas API")
                    .description("API Rest da aplicação Jornada Milhas")
                    .contact(
                        new Contact().name("Equipe de Backend")
                                .email("contato@jornadamilhas.com.br")
                    )
                    .license(
                        new License()
                                .name("Será definido...")
                                .url("http://www.jornadamilhas.com.br/api/licenca")
                    )
            );
    }
}
