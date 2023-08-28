package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class PersonDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank @NotNull
	private String name;
	@NotBlank @NotNull
	private AddressDTO address;
	@NotBlank @NotNull
	private String phone;
	@NotBlank @NotNull
	private String cpf;
	@NotBlank @NotNull
	private Date dateOfBirth;
	private String observations;
	private boolean hasActive;
	
}
