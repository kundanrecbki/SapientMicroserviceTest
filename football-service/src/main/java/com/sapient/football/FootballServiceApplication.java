package com.sapient.football;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class FootballServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballServiceApplication.class, args);
	}
}


@RefreshScope
@RestController
class MessageRestController {

  @Value("${message:Hello default}")
  private String message;

  @GetMapping("/message")
  String getMessage() {
    return this.message;
  }
}
