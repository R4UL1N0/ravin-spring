package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;

import br.com.devxlabs.ravin.models.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull @NotBlank
	private String name;
	@NotNull @NotBlank
	private String description;
	@NotNull @NotBlank
	private String code;
	@NotNull
	private Double costPrice;
	@NotNull
	private Double salePrice;
	@NotNull @NotBlank
	private String preparationTime;
	private String comments;
	@NotNull
	private ProductType productType;
	@NotNull 
	private boolean active;

}
