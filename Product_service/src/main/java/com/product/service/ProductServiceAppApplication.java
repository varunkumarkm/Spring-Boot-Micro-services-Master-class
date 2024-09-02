package com.product.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceAppApplication.class, args);
	}

}
