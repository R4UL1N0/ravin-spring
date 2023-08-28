package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class CustomerDTO extends PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String allergies;
	private boolean vip;

}
