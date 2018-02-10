
package com.emp.dao.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.dao.IItemDao;
import com.emp.model.Item;

@Repository
@Transactional
public class ItemDao extends AbstractDao<Item> implements IItemDao {

	public ItemDao() {
		super(Item.class);
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItemByCategoryId(int id) {
		String hql = "FROM Item where categoryId=:c_id";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("c_id", id);
		return query.list();
	}

}
