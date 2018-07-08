package com.robert.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.robert.model.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	

}
