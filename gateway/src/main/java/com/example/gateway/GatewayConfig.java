package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", r -> r
                        .path("/gallery/*")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://gallery-service"))
                .route("r2", r->r
                        .path("/image/*")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://image-service"))
                .build();
    }
}
