package com.example.mia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiaApplication.class, args);
	}

}
