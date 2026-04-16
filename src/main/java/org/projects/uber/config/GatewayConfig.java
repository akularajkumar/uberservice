package org.projects.uber.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service-route", r -> r.path("/users/**")
                        .uri("lb://USER-SERVICE"))
                .route("ride-service-route", r -> r.path("/rides/**")
                        .uri("lb://RIDE-SERVICE"))
                .route("payment-service-route", r -> r.path("/payments/**")
                        .uri("lb://PAYMENT-SERVICE"))
                .build();
    }

}
