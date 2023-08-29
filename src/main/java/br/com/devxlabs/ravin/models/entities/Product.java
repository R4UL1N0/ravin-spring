package br.com.devxlabs.ravin.models.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import br.com.devxlabs.ravin.models.dtos.ProductDTO;
import br.com.devxlabs.ravin.models.enums.ProductType;
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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@Column(nullable = false)
	private double costPrice;
	
	@Column(nullable = false)
	private double salePrice;
	
	private String preparationTime;
	private String comments;
	
	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private ProductType productType;
	
	@Column(nullable = false)
	private boolean hasActive;
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private Date createdDate;
	
	private String updatedBy;
	private Date updatedDate;

	public Product(ProductDTO data) {
		this.name = data.getName();
		this.description = data.getDescription();
		this.code = data.getCode();
		this.costPrice = data.getCostPrice();
		this.salePrice = data.getSalePrice();
		this.preparationTime = data.getPreparationTime();
		this.comments = data.getComments();
		this.productType = data.getProductType();
		this.hasActive = data.isActive();
	}
	
}
