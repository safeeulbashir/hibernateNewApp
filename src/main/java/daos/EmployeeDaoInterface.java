package daos;

import hiperappEntity.Employee;

public interface EmployeeDaoInterface {

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	Employee findEmployee(Integer employeeId);
	
	
}
