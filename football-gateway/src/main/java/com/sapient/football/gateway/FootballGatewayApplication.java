package com.sapient.football.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FootballGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballGatewayApplication.class, args);
	}

}
