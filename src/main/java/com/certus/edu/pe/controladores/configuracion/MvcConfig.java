package com.certus.edu.pe.controladores.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("principal");
        registry.addViewController("/principal").setViewName("principal");
        registry.addViewController("/home").setViewName("principal");
        registry.addViewController("/inicio").setViewName("principal");
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/bienvenida").setViewName("bienvenida");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/estudiantes").setViewName("estudiantes");
        registry.addViewController("/profesores").setViewName("profesores");
        registry.addViewController("/cursos").setViewName("cursos");
    }
}
