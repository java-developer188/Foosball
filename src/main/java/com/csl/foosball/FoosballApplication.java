package com.csl.foosball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.csl.foosball.repository")
public class FoosballApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoosballApplication.class, args);
	}

}
