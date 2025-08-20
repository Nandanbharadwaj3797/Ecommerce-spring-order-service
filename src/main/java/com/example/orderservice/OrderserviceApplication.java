package com.example.orderservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class OrderserviceApplication {

	public static void main(String[] args) {
		Dotenv dotenv=Dotenv.configure().load();
		dotenv.entries().forEach(entry->System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(OrderserviceApplication.class, args);

	}

}
