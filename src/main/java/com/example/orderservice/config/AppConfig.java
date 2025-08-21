package com.example.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

//Adding Load Balanced on a RestTemplate enable client side Load Balancing
// It intercept the local service names and resolves them into actual instances url from eureka

// Eureka client > Product_service
// ECOMMERCE_SPRING is not dns
// Load balancer contacts Eureka -> fetch the available instance >pick one



