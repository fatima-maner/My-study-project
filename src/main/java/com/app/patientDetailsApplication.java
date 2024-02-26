package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class patientDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(patientDetailsApplication.class, args);
	}
		
}
