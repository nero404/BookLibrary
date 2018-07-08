package com.robert.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.robert.model.UserType;

public interface UserTypeDao extends JpaRepository<UserType, Integer> {

	

}
