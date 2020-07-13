package com.sapient.football.entity;

import java.io.Serializable;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Country implements Serializable{

	private static final long serialVersionUID = -1254403425516685263L;
	
	@Id
	@GeneratedValue
	private Integer countryId;
	private String countryName;
	private String countryLogo;
}
