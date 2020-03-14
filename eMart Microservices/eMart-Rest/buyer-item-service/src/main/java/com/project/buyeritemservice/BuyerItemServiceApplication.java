package com.project.buyeritemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BuyerItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerItemServiceApplication.class, args);
	}

}
