package hyperapp.hyperapp;

import hiperappEntity.Address;
import hiperappEntity.Employee;
import hiperappEntity.Salary;
import services.EmployeeServices;

public class Application {

	public static void main(String args[]) {
		Salary salary = new Salary();
		Employee employee = new Employee();
		Address address = new Address();
		employee.SetEmployee(1, "Safee", "Bashir", "M", 10);
		salary.setSalary(null, 65000);
		employee.setSalary(salary);
		salary.setEmployee(employee);
		address.setAddress(null, "1026 San Jacinto Dr.", "Irving", "Texas", "USA", employee);
		employee.getAddressSet().add(address);
		EmployeeServices employeeServices = new EmployeeServices();
		employeeServices.addRecords(employee, salary, address);
	}
}
