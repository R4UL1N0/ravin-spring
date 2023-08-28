package br.com.devxlabs.ravin.models.dtos;

import java.io.Serializable;
import java.util.List;

import br.com.devxlabs.ravin.models.enums.TableStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class TableDTO implements Serializable {

	private EmployeeDTO employee;
	private List<TabDTO> tabs;
	private String name;
	private String code;
	private int number;
	private TableStatus tableStatus;

}
