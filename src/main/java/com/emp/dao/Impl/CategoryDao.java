package com.emp.dao.Impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.emp.dao.ICategoryDao;
import com.emp.model.Category;

@Repository
@Transactional
public class CategoryDao extends AbstractDao<Category>implements ICategoryDao {

	public CategoryDao() {
		super(Category.class);
	
	}

}
