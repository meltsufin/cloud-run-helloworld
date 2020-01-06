package com.example.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloworldApplication {

	private final static Logger log = LoggerFactory.getLogger(HelloworldApplication.class);

	@Value("${TARGET:World}")
	String target;

	@RestController
	class HelloworldController {
		@GetMapping("/")
		String hello() {
			log.info("Saying hello!");
			log.trace("Test info log!");
			log.trace("Test trace log!");
			log.debug("Test debug log!");
			log.warn("Test warning log!");
			log.error("Test error log!");

			return "Hello " + target + "!";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
