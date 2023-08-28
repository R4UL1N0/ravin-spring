package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;
import java.util.Date;

import br.com.devxlabs.ravin.models.enums.EmployeeAviability;
import br.com.devxlabs.ravin.models.enums.MeritalStatus;
import br.com.devxlabs.ravin.models.enums.Responsibility;
import br.com.devxlabs.ravin.models.enums.Schooling;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class EmployeeDTO extends PersonDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String rg;

	private MeritalStatus meritalStatus;

	private Schooling schooling;

	private Responsibility responsability;

	private int pis;

	private Date admissionDate;
	private Date resignationDate;
	private EmployeeAviability employeeAviability;

}
