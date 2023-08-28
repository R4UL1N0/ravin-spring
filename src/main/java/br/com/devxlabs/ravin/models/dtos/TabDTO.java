package br.com.devxlabs.ravin.models.dtos;

import java.util.List;

import br.com.devxlabs.ravin.models.enums.TabStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class TabDTO {

	private TableDTO table;
	private CustomerDTO customer;
	private List<OrderDetailDTO> orderDetails;
	private String code;
	private String comments;
	private TabStatus tabStatus;


}
