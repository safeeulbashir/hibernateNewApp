package services;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.util.HibernateUtil;
import hiperappEntity.Address;
import hiperappEntity.Employee;
import hiperappEntity.Salary;

public class EmployeeServices {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void addRecords(Employee employee, Salary salary, Address address) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Serializable emp = session.save(employee);
			transaction.commit();
		} catch (Exception exception) {
			// TODO: handle exception
			transaction.rollback();
			exception.printStackTrace();
		}
		session.close();
	}

	public Employee viewRecordByCriteria() {
		/*
		 * Session session = sessionFactory.openSession(); String queryString
		 * ="from employee where employeeId = :employeeId";
		 * org.hibernate.query.Query query = session.createQuery(queryString);
		 * query.setParameter(1, new Integer(1)); Employee employee = (Employee)
		 * query.uniqueResult();
		 * 
		 * 
		 * Query query = session.createQuery("from employees");
		 * query.setParameter("id", "1"); List<Employee> listCategories =
		 * ((org.hibernate.query.Query) query).list();
		 * System.out.println(employee.getFirstName()); session.close();
		 */
		Session session = sessionFactory.openSession();

		Integer id = new Integer(1);

		try {
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Employee.class);
			Criteria criteria2 = criteria.createCriteria("salary");
			// Showing data which is greater than 60000
			criteria2.add(Restrictions.ge("salary", new Integer(60000)));
			// criteria.add(Restrictions.eq("employeeId", id));
			Employee employee = (Employee) criteria2.uniqueResult();

			if (employee != null) {
				System.out.println(employee.getSalary().getSalary());
				return employee;
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return null;

	}

	public Employee viewRecordByHQL() {
		Session session = sessionFactory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();

		Query query = session.createQuery("from Employee where salary.salary>60000");//
		Employee employee = (Employee) query.uniqueResult();
		System.out.println("salary= "+employee.getSalary().getSalary());
		t.commit();
		session.close();
		return employee;
	}

}
