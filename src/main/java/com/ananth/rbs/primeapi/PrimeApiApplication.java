package com.ananth.rbs.primeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PrimeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeApiApplication.class, args);
	}
}
