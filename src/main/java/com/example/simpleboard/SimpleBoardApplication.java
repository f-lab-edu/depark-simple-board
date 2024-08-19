package com.example.simpleboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBoardApplication.class, args);
	}
}
