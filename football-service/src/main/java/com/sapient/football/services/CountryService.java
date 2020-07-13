package com.sapient.football.services;

import java.util.List;

import com.sapient.football.entity.Country;

public interface CountryService {

	Country getCountryById(int countryId);

	Country addCountry(Country Country);

	Country updateCountry(int countryId, Country Country);

	void deleteCountry(int countryId);

	List<Country> getCountries();

}
