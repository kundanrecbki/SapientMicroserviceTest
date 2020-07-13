package com.sapient.football.dao;

import java.util.List;

import com.sapient.football.entity.Country;

public interface CountryDaoService {
	
	Country findOne(int countryId);

	Country save(Country Country);

	Country update(int countryId, Country Country);


	List<Country> findAll();

	void deleteById(int countryId);
}
