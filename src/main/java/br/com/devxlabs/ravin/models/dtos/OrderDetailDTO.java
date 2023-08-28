package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

import br.com.devxlabs.ravin.models.enums.PreparationOrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class OrderDetailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProductDTO product;
	private Timestamp requestDateTime;
	private Timestamp startPreparationDateTime;
	private Timestamp reminingPreparationTime;
	private PreparationOrderStatus preparationOrderStatus;
	private String comments;
	private int quantity;

}
