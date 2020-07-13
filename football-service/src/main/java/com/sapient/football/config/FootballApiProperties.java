package com.sapient.football.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties("remote.footballapi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballApiProperties {
	private String countryurl;
	private String competitionsurl;
	private String teamsurl;
	private String standingsurl;
	private String apikey;
}
