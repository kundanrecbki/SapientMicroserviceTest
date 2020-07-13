package com.sapient.football.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.football.entity.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CountryDaoServiceImpl implements CountryDaoService{
	
	private static List<Country> countries = new ArrayList<>();
	private static int countryCount = 3;
	static {
		countries.add(Country.builder()
			 	.countryId(1)
			 	.countryName("England")
			 	.countryLogo("https://apiv2.apifootball.com/badges/logo_country/41_england.png")
			 	.build());
		countries.add(Country.builder()
			 	.countryId(2)
			 	.countryName("France")
			 	.countryLogo("https://apiv2.apifootball.com/badges/logo_country/42_France.png")
			 	.build());
		countries.add(Country.builder()
			 	.countryId(3)
			 	.countryName("Germany")
			 	.countryLogo("https://apiv2.apifootball.com/badges/logo_country/3_Germany.png")
			 	.build());
	}
	@Override
	public Country findOne(int countryId) {
		log.debug("Countries are " + countries);
		for (Country country : countries) {
			if (country.getCountryId() == countryId) {
				return country;
			}
		}
		return null;
	}
	@Override
	public Country save(Country country) {
		if (country.getCountryId() == null) {
			country.setCountryId(++countryCount);
		}
		countries.add(country);
		return country;
	}
	@Override
	public Country update(int countryId, Country country) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteById(int countryId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Country> findAll() {
		return countries;
	}

}
