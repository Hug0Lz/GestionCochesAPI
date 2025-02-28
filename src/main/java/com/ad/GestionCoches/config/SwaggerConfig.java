package com.ad.GestionCoches.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Coches")
                        .version("1.0")
                        .description("Documentación de la API para gestionar coches de un concesionario y sus respectivos servicios.")
                        .contact(new Contact()
                                .name("Equipo de Soporte")
                                .email("soporte@cochero.com")
                                .url("https://www.cochero.com"))
                );
    }
}