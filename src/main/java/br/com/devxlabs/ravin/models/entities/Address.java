package br.com.devxlabs.ravin.models.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter @Setter @NoArgsConstructor @ToString
public class Address {

	private String state;
	private String city;
	private String street;
	private String zipCode;

}
