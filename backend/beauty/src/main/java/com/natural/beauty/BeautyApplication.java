package com.natural.beauty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeautyApplication {

	private static final Logger log = LoggerFactory.getLogger(BeautyApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BeautyApplication.class, args);
	}

}
