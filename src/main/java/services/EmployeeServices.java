package services;

import daos.EmployeeDaoImpl;
import daos.EmployeeDaoInterface;
import hiperappPojos.Employee;

public class EmployeeServices {

	public void addEmployee() {
		Employee employee = new Employee(2, "Safee", "Bashir", 60000, "IT");
		EmployeeDaoInterface employeeDao = new EmployeeDaoImpl();
		employeeDao.addEmployee(employee);
	}
	public void updateEmployee() {
		Employee employee = new Employee(2, "Safeeul", "Bashir", 65000, "IT");
		EmployeeDaoInterface employeeDao = new EmployeeDaoImpl();
		employeeDao.updateEmployee(employee);
	}
	public Employee findEmployee(Integer employeeId)
	{
		EmployeeDaoInterface employeeDao = new EmployeeDaoImpl();
		return employeeDao.findEmployee(employeeId);
	}

}
