package com.app.tap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ConfigCors implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")               // La notación /** permite solicitudes Cors para todas las rutas de la aplicación.
                .allowedOrigins("http://localhost:8081")    // Reemplaza con el origen que desees permitir.
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("Authorization")
                .allowCredentials(false)    //desabilita la autenticacion
                .maxAge(3600);              //Tiempo de la autenticacion
    }
}