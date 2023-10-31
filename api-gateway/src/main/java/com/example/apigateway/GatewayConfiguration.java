package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

                // Student info Service
                .route(p -> p.path("/api/students/**")
                        .uri("lb://student-info-service"))

                // Grades data Service
                .route(p -> p.path("/api/grades/**")
                        .uri("lb://grades-data-service"))
                .route(p -> p.path("/api/courses/**")
                        .uri("lb://grades-data-service"))

                // Student catalog Service
                .route(p -> p.path("/api/catalogs/**")
                        .uri("lb://student-catalog-service"))

                .build();
    }
}
