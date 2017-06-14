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
		Address address2 = new Address();
		employee.SetEmployee(2, "Sharat", "Chandra", "M", 10);
		salary.setSalary(null, 55000);
		employee.setSalary(salary);
		salary.setEmployee(employee);
		address.setAddress(null, "1026 San Jacinto Dr.", "Irving", "Texas", "USA", employee);
		address2.setAddress(null, "959 Buena Vista Dr. SE", "Albuquerque", "New Mexico", "USA", employee);
		employee.getAddressSet().add(address);
		employee.getAddressSet().add(address2);
		EmployeeServices employeeServices = new EmployeeServices();
		employeeServices.addRecords(employee, salary, address);
		System.out.println("Name: "+employeeServices.viewRecordByCriteria().getFirstName() + " "
				+ employeeServices.viewRecordByCriteria().getLastName());
		System.err.println("Salary: "+employeeServices.viewRecordByCriteria().getSalary().getSalary());
		System.out.println(employeeServices.viewRecordByHQL().getFirstName() + " "
				+ employeeServices.viewRecordByHQL().getLastName());

	}
}
