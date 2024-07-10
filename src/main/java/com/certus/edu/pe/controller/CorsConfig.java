package com.certus.edu.pe.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("/**") // Permitir solicitudes desde este origen
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // Métodos permitidos
	                .allowedHeaders("*") // Permitir todos los encabezados
	                .allowCredentials(true); // Permitir credenciales (opcional)
	    }
}
