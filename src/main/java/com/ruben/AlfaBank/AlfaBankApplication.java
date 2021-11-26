package com.ruben.AlfaBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlfaBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfaBankApplication.class, args);
	}

}