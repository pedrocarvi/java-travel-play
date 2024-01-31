/*package com.app.tap;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class ConfigCors implements WebMvcConfigurer {
    @Override
    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/**")                      // La notación /** permite solicitudes Cors para todas las rutas de la aplicación.
                .allowedOrigins("http://localhost:8081")          // Reemplaza con el origen que desees permitir
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Authorization")
                .allowCredentials(true);
    }
} */
