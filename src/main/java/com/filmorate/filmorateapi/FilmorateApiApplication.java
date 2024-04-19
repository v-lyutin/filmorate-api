package com.filmorate.filmorateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FilmorateApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(FilmorateApiApplication.class, args);
	}
}
