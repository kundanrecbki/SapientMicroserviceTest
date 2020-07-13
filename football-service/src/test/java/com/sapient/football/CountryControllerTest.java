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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import com.sapient.football.controller.CountriesController;
import com.sapient.football.entity.Country;
import com.sapient.football.services.CountryService;


@WebMvcTest(CountriesController.class)
public class CountryControllerTest {
	@Autowired
	MockMvc mockMvc;
	
    @Autowired
    ObjectMapper objectMapper;
    
    @MockBean
    CountryService countryService;
    
    
	@Test
	void getCountryById() throws Exception{
		given(countryService.getCountryById(any())).willReturn(getValidCountry());
		mockMvc.perform(get("/api/v1/countries/" + "41").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
    void addCountry() throws Exception {

		Country Country = getValidCountry();
        String CountryJson = objectMapper.writeValueAsString(Country);

        given(countryService.addCountry(any())).willReturn(getValidCountry());

        mockMvc.perform(post("/api/v1/countries/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CountryJson))
                .andExpect(status().isCreated());
    }
	
    @Test
    void updateCountry() throws Exception {
        given(countryService.updateCountry(any(), any())).willReturn(getValidCountry());

        Country Country = getValidCountry();
        String CountryJson = objectMapper.writeValueAsString(Country);

        mockMvc.perform(put("/api/v1/countries/" + "41")
                .contentType(MediaType.APPLICATION_JSON)
                .content(CountryJson))
                .andExpect(status().isNoContent());
    }
	
    Country getValidCountry(){
        return Country.builder()
    		 	.countryId(41)
    		 	.countryName("England")
    		 	.countryLogo("https://apiv2.apifootball.com/badges/logo_country/41_england.png")
    		 	.build();
    }
}
