package com.robert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.dao.UserDao;
import com.robert.model.User;



@Service
public class RegistrationService {
	
	@Autowired
	private UserDao userDao;
	

	

}
