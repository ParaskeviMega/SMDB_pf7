package com.pf7.smdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmdbPf7Application {
	private static final Logger logger = LoggerFactory.getLogger(SmdbPf7Application.class);

	public static void main(String[] args) {
		//SpringApplication.run(SmdbPf7Application.class, args);
		logger.info("Hello");
	}
}
