package com.flux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluxDbApplication {

	static final Logger LOGGER = LoggerFactory.getLogger(FluxDbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FluxDbApplication.class, args);
	}

}
