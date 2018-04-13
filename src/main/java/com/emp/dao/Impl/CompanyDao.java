package com.emp.dao.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.dao.ICompanyDao;
import com.emp.model.Company;

@Repository
@Transactional
public class CompanyDao extends AbstractDao<Company> implements ICompanyDao {

	public CompanyDao() {
		super(Company.class);

	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAll(int start, int limit, String order) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Company.class);
		crit.setFirstResult(start);
		crit.setMaxResults(limit);
		crit.addOrder(Order.asc("companyName"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getByName(String name, int start, int limit, String order) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Company.class);
		crit.add(Restrictions.eq("name", name));
		crit.setFirstResult(start);
		crit.setMaxResults(limit);
		crit.addOrder(Order.asc(order));
		return crit.list();
	}

}
