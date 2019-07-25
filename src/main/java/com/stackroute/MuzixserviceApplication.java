package com.stackroute;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.logging.Logger;

@SpringBootApplication
//Run method which is used to run the application
public class MuzixserviceApplication  {
	public static void main(String[] args) {
		SpringApplication.run(MuzixserviceApplication.class, args);
	}
}
