package com.stackroute;

import com.stackroute.controller.MuzixController;
import com.stackroute.domain.Muzix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.ls.LSOutput;

@SpringBootApplication
public class MuzixApplication {

	public static void main(String[] args) {
		//Running the application
		SpringApplication.run(MuzixApplication.class, args);
	}

}
