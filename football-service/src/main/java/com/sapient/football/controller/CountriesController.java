package com.sapient.football.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.sapient.football.entity.Country;
import com.sapient.football.exception.CountryNotFoundException;
import com.sapient.football.services.CountryService;

@RequestMapping("/api/v1/countries")
@RestController
public class CountriesController {
	
	@Autowired
	private CountryService countryService;
	
	
	
	
	
	@GetMapping("/{countryId}")
	public EntityModel<Country> getCountry(@PathVariable int countryId){
		Country country = countryService.getCountryById(countryId);
		if(country==null)
			throw new CountryNotFoundException("countryId-"+ countryId);
		
		EntityModel<Country> resource = EntityModel.of(country);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getCountries());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS
		
		return resource;
	}
	
	@GetMapping
	public ResponseEntity<List<Country>> getCountries(){
		return new ResponseEntity<List<Country>>(countryService.getCountries(), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping
	public ResponseEntity addCountry(@RequestBody Country Country) {
		Country savedDto = countryService.addCountry(Country);
		HttpHeaders headers = new HttpHeaders();
			headers.add("Location", savedDto.getCountryId().toString());
		return new ResponseEntity (headers, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@PutMapping("/{countryId}")
	public ResponseEntity updateCountry(@PathVariable int countryId, @RequestBody Country Country ){
		countryService.updateCountry(countryId, Country);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{countryId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCountry(@PathVariable("countryId") int countryId) {
		countryService.deleteCountry(countryId);
	}
	

}
