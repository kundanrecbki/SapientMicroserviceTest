package com.sapient.football.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FootballEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballEurekaApplication.class, args);
	}

}
