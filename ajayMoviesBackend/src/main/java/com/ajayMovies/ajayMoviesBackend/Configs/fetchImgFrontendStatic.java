package com.ajayMovies.ajayMoviesBackend.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class fetchImgFrontendStatic implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/movies/**")
                .addResourceLocations("file:D:/SDE-Projects/Spring Boot + Angular/02 - Ajay Movies/uploads/movies/");
        
        registry.addResourceHandler("/movies/posters/**")
                .addResourceLocations("file:D:/SDE-Projects/Spring Boot + Angular/02 - Ajay Movies/uploads/movies/posters/");
                
        registry.addResourceHandler("/movies/screenshots/**")
                .addResourceLocations("file:D:/SDE-Projects/Spring Boot + Angular/02 - Ajay Movies/uploads/movies/screenshots/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
