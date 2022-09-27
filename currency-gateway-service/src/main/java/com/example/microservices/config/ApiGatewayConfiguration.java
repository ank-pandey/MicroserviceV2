package com.example.microservices.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f
								.addRequestHeader("customHeader", "headerValue")
								.addRequestParameter("customParam", "paramValue"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**")
						.uri("lb://currency-exchange-service"))
				.route(p -> p.path("/currency-conversion/**")
						.uri("lb://currency-conversion-service"))
				.route(p -> p.path("/feign/**")
						.uri("lb://currency-conversion-service"))
				.build();
	}
}