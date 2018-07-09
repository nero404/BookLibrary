package com.robert.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.dao.CategoryDao;
import com.robert.model.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findById(int id) {
		return categoryDao.findOne(id);
	}

}
