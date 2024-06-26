package com.example.mypack.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

	@Value("${gym.swagger.dev-url}")
	private String devUrl;

	@Value("${gym.swagger.prod-url}")
	private String prodUrl;

	@Bean
	public OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL in Development environment");

		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription("Server URL in Production environment");

		Contact contact = new Contact();
		contact.setEmail("khan.farhan1985@gmail.com");
		contact.setName("Farhan");
		contact.setUrl("www.google.com");

		License license = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

		Info info = new Info().title("Gym Management API").version("v1.0").contact(contact)
				.description("This API exposes endpoints to manage gym related activities.")
				.termsOfService("www.google.com").license(license);
		return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	}

}
