package br.com.devxlabs.ravin.models.entities;

import java.util.Date;

import br.com.devxlabs.ravin.models.enums.EmployeeAviability;
import br.com.devxlabs.ravin.models.enums.MeritalStatus;
import br.com.devxlabs.ravin.models.enums.Responsibility;
import br.com.devxlabs.ravin.models.enums.Schooling;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Employee extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	private String rg;

	@Enumerated(value = EnumType.STRING)
	private MeritalStatus meritalStatus;

	@Enumerated(value = EnumType.STRING)
	private Schooling schooling;

	@Enumerated(value = EnumType.STRING)
	private Responsibility responsability;

	@Column(unique = true, nullable = false)
	private int pis;

	private Date admissionDate;
	private Date resignationDate;

	@Enumerated(value = EnumType.STRING)
	private EmployeeAviability employeeAviability;


}
