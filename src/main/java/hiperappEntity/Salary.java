package hiperappEntity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
public class Salary implements Serializable {
	@GenericGenerator(name = "generator", strategy = "foreign",
	parameters = @Parameter(name = "property", value = "employee"))
	@Id
	@GeneratedValue(generator = "generator")
	private Integer employeeId;
	private Integer salary;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Employee employee;
	public Integer getSalaryId() {
		return employeeId;
	}
	public void setSalaryId(Integer salaryId) {
		this.employeeId = salaryId;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Salary(Integer salaryId, Integer salary, Employee employee) {
		super();
		this.employeeId = salaryId;
		this.salary = salary;
		this.employee = employee;
	}
	public void setSalary(Integer salaryId, Integer salary) {
		
		this.employeeId = salaryId;
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
		
}
