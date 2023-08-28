package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String state;
	private String city;
	private String street;
	private String zipCode;


}
