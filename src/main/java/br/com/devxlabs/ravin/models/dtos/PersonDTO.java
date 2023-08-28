package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class PersonDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private AddressDTO address;
	private String phone;
	private String cpf;
	private Date dateOfBirth;
	private String observations;
	private boolean hasActive;
	
}
