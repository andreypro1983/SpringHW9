package ru.geekbrains.SpringHW9ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHw9ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHw9ApiGatewayApplication.class, args);
	}
	// настройка микросервисов в apigateway
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("Microservice1",r->r.path("/notes/**")
						.uri("http://localhost:8896/"))
				.route("Microservice2",r->r.path("/tasks/**")
						.uri("http://localhost:8897/")).build();}
}
