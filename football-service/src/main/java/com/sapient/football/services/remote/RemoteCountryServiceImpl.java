package com.sapient.football.services.remote;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.config.FootballApiProperties;
import com.sapient.football.model.RemoteCountryDto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RemoteCountryServiceImpl implements RemoteCountryService {
	
	@Autowired
	private FootballApiProperties properties;
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("spring.cloud.config.uri")
	private String configServerPath;
	@Bean
	public RestTemplate getRestTemplate() {
	    return new RestTemplate();
	}
//	public RemoteCountryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
//		this.restTemplate = restTemplateBuilder.build();
//	}
	
	@Cacheable(cacheNames = "countryListCache")
	@Override
	public List<RemoteCountryDto> getCountries() {
		log.debug("------------>>>>>>>>>    I was called - RemoteCountryServiceImpl.getCountries()");
		log.debug("------------>>>>>>>>>  Properties:" + properties);
		log.debug("------------>>>>>>>>>  " +  configServerPath);
		String url = properties.getCountryurl()+"&APIkey="+properties.getApikey();
		log.debug("------------>>>>>>>>>  URL Constructed: " + url);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	    RemoteCountryDto[] response = restTemplate.exchange(url, HttpMethod.GET, entity, RemoteCountryDto[].class).getBody();
	    log.debug("Inside RemoteCountryServiceImpl:" + response);
		return Arrays.asList(response);
	}

}
