package com.furnitureapp.ar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ArApplication.class, args);}
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}

}
