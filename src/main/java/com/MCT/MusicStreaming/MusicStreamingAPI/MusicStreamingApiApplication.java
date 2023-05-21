package com.MCT.MusicStreaming.MusicStreamingAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MusicStreamingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicStreamingApiApplication.class, args);
	}

}
