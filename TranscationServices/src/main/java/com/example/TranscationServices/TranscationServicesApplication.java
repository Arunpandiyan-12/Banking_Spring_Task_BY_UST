package com.example.TranscationServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class TranscationServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranscationServicesApplication.class, args);
	}

}
