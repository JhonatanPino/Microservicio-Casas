package com.pragma.microserviciocasas.commons.configurations.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio-Casas")
                        .version("1.0")
                        .description("API para la gestión de propiedades en la plataforma Hogar360")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación oficial")
                        .url("https://Microservicio-Casas.com/docs"));
    }

    @Bean
    public GroupedOpenApi categoryApi() {
        return GroupedOpenApi.builder().group("categories")
                .packagesToScan("com.pragma.microserviciocasas.infrastructure.endpoints.rest") // Escanea el paquete de CategoryController
                .build();
    }

    @Bean
    public GroupedOpenApi locationApi() {
        return GroupedOpenApi.builder().group("locations")
                .packagesToScan("com.pragma.microserviciocasas.infrastructure.endpoints.rest") // Escanea el paquete de LocationController
                .build();
    }


}
