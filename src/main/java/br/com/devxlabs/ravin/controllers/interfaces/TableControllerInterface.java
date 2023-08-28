package br.com.devxlabs.ravin.controllers.interfaces;

import br.com.devxlabs.ravin.models.entities.Employee;
import br.com.devxlabs.ravin.models.entities.Tab;
import br.com.devxlabs.ravin.models.entities.RestaurantTable;

public interface TableControllerInterface extends ControllerInterface<RestaurantTable> {
	
	public void bookTable() throws Exception;
	public void clearTable() throws Exception;
	public void occupyTable() throws Exception;
	public void allocateEmployee(Employee employee);
	public void addCommanda(Tab commanda);

}
