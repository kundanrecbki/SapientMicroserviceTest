package com.sapient.football.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.football.dao.CountryDaoService;
import com.sapient.football.entity.Country;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryDaoService countryDaoService;
	
	@Override
	public Country getCountryById(int countryId) {
		return countryDaoService.findOne(countryId);
	}

	@Override
	public Country addCountry(Country country) {
		return countryDaoService.save(country);
	}

	@Override
	public Country updateCountry(int countryId, Country country) {
		return countryDaoService.update(countryId, country);
	}

	@Override
	public void deleteCountry(int countryId) {
		countryDaoService.deleteById(countryId);
	}

	@Override
	public List<Country> getCountries() {
		return countryDaoService.findAll();
	}	
}
