package ru.job4j.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the calculator application.
 */
@SpringBootApplication
public class CalcApplication {
	/**
	 * Creates an empty CalcApplication object.
	 */
	public CalcApplication() {
	}

	/**
	 * Runs the Spring Boot application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CalcApplication.class, args);
	}
}
