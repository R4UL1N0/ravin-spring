package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;

import br.com.devxlabs.ravin.models.enums.ProductType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty @NotBlank
	private String name;
	@NotEmpty @NotBlank
	private String description;
	@NotEmpty @NotBlank
	private String code;
	@NotEmpty
	@DecimalMin(value = "0", message = "O preço de venda não pode ser negativo.")
	private Double costPrice;
	@NotEmpty
	@DecimalMin(value = "0", message = "O preço de venda não pode ser negativo.")
	private Double salePrice;
	@NotEmpty @NotBlank
	private String preparationTime;
	private String comments;
	@NotEmpty
	private ProductType productType;
	@NotEmpty 
	private boolean active;

}
