package com.emp.dao.Impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.emp.dao.IFileDao;
import com.emp.model.File;

@Repository
@Transactional
public class FileDao extends AbstractDao<File> implements IFileDao {

	public FileDao() {
		super(File.class);
	}

}
