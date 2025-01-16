package com.convenience.convenience;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConvenienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvenienceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setFieldAccessLevel(AccessLevel.PRIVATE)
				.setFieldMatchingEnabled(true);
		return modelMapper;
	}

}
