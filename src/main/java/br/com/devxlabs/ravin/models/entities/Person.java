package br.com.devxlabs.ravin.models.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Embedded
	private Address address;
	private String phone;

	@Column(nullable = false, unique = true)
	private String cpf;
	private Date dateOfBirth;
	private String observations;

	@Column(nullable = false)
	private boolean hasActive;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private Date createdDate;

	private String updatedBy;
	private Date updatedDate;

}
