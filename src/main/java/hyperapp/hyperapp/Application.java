package hyperapp.hyperapp;

import hiperappPojos.Employee;
import services.EmployeeServices;

public class Application {

	public static void main(String args[])
	{
		EmployeeServices employeeServices= new EmployeeServices();
		employeeServices.addEmployee();
		//System.out.println(employeeServices.findEmployee(1).toString());*/
		employeeServices.updateEmployee();
		Employee employee=employeeServices.findEmployee(2);
		System.out.println(employee.getFirstName()+" "+employee.getLastName());
	}
}
