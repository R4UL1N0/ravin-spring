package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;

import br.com.devxlabs.ravin.models.enums.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String code;
	private double costPrice;
	private double salePrice;
	private String preparationTime;
	private String comments;
	private ProductType productType;
	private boolean hasActive;

}
