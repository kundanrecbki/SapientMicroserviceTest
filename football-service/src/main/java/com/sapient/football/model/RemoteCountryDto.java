package com.sapient.football.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoteCountryDto implements Serializable{

	private static final long serialVersionUID = -5222808418161989333L;
	
	private String country_id;
	private String country_name;
	private String country_logo;
}
