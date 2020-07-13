package com.sapient.football.services.remote;

import java.util.List;


import com.sapient.football.model.RemoteCountryDto;

public interface RemoteCountryService {

	List<RemoteCountryDto> getCountries();
	
}
