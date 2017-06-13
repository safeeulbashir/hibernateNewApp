package daos;

import java.io.Serializable;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import hiperappEntity.Employee;

public class EmployeeDaoImpl implements EmployeeDaoInterface {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Serializable serializable = session.save(employee);
			transaction.commit();
		} catch (Exception exception) {
			// TODO: handle exception
			transaction.rollback();
			exception.printStackTrace();
		}
		session.close();
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(employee);
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public Employee findEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return sessionFactory.openSession().load(Employee.class, new Integer(employeeId));
	}
}
