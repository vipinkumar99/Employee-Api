package com.emp.dao.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.dao.IEmployeeDao;
import com.emp.model.Employee;

@Repository
@Transactional
public class EmployeeDao extends AbstractDao<Employee> implements IEmployeeDao {

	public EmployeeDao() {
		super(Employee.class);
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public List<Employee> viewAllEmployeeList() {
	// List<Employee> employeeList = getCurrentSession().createQuery("FROM
	// Employee").list();
	// return employeeList;
	// }
	//
	// @Override
	// public void saveEmployeeRecord(Employee employee) {
	// getCurrentSession().save(employee);
	//
	// }
	/*
	 * @Override public Employee viewEmployeeById(int employeeId) {
	 * 
	 * return (Employee)getCurrentSession().get(Employee.class,employeeId); }
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> viewEmployeeByName(String employeeName) {
		String hql = "FROM Employee where employeeName=:ename";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("ename", employeeName);
		return query.list();
//		List<Employee> employeeList = getCurrentSession().createQuery(hql).list();
//		return employeeList;

	}

	@Override
	public double sum(String employee) {
		//getCurrentSession()
		return 0;
	}

	// @Override
	// public void updateEmployee(Employee employee) {
	// getCurrentSession().update(employee);
	//
	// }
	//
	// @Override
	// public void deleteEmployee(int id) {
	// Employee employee = viewEmployeeById(id);
	// getCurrentSession().delete(employee);
	//
	// }

}
