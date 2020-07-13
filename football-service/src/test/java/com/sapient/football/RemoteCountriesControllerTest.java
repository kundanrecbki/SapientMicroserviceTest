package com.sapient.football;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.football.controller.remote.RemoteCountriesController;
import com.sapient.football.services.remote.RemoteCountryService;

@WebMvcTest(RemoteCountriesController.class)
public class RemoteCountriesControllerTest {
	@Autowired
	MockMvc mockMvc;
	
    @Autowired
    ObjectMapper objectMapper;
    
    @MockBean
    RemoteCountryService remoteCountryService;
    
    
	@Test
	void getCountries() throws Exception{
		mockMvc.perform(get("/api/v1/remote/countries/").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
}
