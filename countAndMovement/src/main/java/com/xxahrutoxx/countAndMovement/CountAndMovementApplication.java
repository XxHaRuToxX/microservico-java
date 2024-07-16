package com.xxahrutoxx.countAndMovement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CountAndMovementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountAndMovementApplication.class, args);
	}

}
