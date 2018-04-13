package com.emp.dao.Impl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.dao.IAdminDao;
import com.emp.model.Admin;

@Repository
@Transactional
public class AdminDao extends AbstractDao<Admin> implements IAdminDao {

	public AdminDao() {
		super(Admin.class);
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Admin getByUserName(String userName) {
		String hql = "FROM Admin where userName=:uname";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("uname", userName);
		return (Admin) query.uniqueResult();
	}

	@Override
	public Admin getByMobileNumber(long mobileNumber) {
		String hql = "FROM Admin where mobileNumber=:mobile";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("mobile", mobileNumber);
		return (Admin) query.uniqueResult();
	}

	@Override
	public Admin getByEmailId(String emailId) {
		String hql = "FROM Admin where email=:adminEmail";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("adminEmail", emailId);
		return (Admin) query.uniqueResult();
	}

	@Override
	public Admin validatePassword(String password) {
		String hql = "FROM Admin where password=:upass";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("upass", password);
		return (Admin) query.uniqueResult();
	}

}
