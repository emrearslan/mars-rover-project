package com.ea.marsRover.application;

import com.ea.marsRover.config.ApplicationConfiguration;
import com.ea.marsRover.config.RestConfiguration;
import com.ea.marsRover.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ ApplicationConfiguration.class, RestConfiguration.class, SwaggerConfiguration.class })
public class MarsRoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApplication.class, args);
	}

}
