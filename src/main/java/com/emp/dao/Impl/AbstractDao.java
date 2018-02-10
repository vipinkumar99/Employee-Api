package com.emp.dao.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.dao.IAbstractDao;


@Repository
@Transactional
public abstract class AbstractDao<T> implements IAbstractDao<T> {

	Class<T> entityClass;

	public AbstractDao(Class<T> entityType) {
		entityClass = entityType;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T itemToSave) {
		getCurrentSession().save(itemToSave);
	}

	@Override
	public void update(T itemToUpdate) {
		getCurrentSession().update(itemToUpdate);
	}

	@Override
	public void delete(int id) {
		T item = getById(id);
		getCurrentSession().delete(item);
	}

	@Override
	public List<T> all() {
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) getCurrentSession().createQuery("FROM   " + entityClass.getName()).list();
		return list;
	}

	@Override
	public T getById(int id) {
		return getCurrentSession().get(entityClass, id);
	}

	
	
	
}
