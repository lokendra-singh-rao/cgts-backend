package com.ayratech.cgts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.ayratech.cgts")
public class CgtsApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(CgtsApplication.class, args);
	}

}
