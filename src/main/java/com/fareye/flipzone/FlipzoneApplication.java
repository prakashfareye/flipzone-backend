package com.fareye.flipzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Column;

@SpringBootApplication
public class FlipzoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipzoneApplication.class, args);
		System.out.println("Hello World");
	}

}
