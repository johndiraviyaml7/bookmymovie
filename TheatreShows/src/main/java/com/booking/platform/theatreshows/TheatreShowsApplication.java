package com.booking.platform.theatreshows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;



@SpringBootApplication
@EnableEncryptableProperties
public class TheatreShowsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreShowsApplication.class, args);
	}

	}