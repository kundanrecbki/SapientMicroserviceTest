package com.sapient.football.controller.remote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.football.model.RemoteCountryDto;
import com.sapient.football.services.remote.RemoteCountryService;

@RequestMapping("/api/v1/remote/countries")
@RestController
public class RemoteCountriesController {
	
	
	@Autowired
	private RemoteCountryService countryService;
	
	@GetMapping
	public ResponseEntity<List<RemoteCountryDto>> getCountries(){
		return new ResponseEntity<List<RemoteCountryDto>>(countryService.getCountries(), HttpStatus.OK);
	}
}
