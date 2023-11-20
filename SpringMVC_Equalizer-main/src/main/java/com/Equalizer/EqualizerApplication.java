package com.Equalizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.Equalizer")

@SpringBootApplication
public class EqualizerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EqualizerApplication.class, args);
	}
}
