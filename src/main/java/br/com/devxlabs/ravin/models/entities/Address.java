package br.com.devxlabs.ravin.models.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter @Setter @NoArgsConstructor @ToString
public class Address {

	@NotBlank @NotNull
	private String state;
	@NotBlank @NotNull
	private String city;
	@NotBlank @NotNull
	private String street;
	@NotBlank @NotNull
	private String zipCode;

}
