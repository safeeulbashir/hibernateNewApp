package services;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

}
