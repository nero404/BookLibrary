package com.robert.service;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.robert.dao.UserDao;
import com.robert.dao.UserTypeDao;
import com.robert.model.User;

@Service
public class UserService {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserDao userDao;
	@Autowired
	CartService cartService;
	@Autowired
	UserTypeDao userTypeDao;

	public User signIn(String login, String password) {
		User user = userDao.findByLoginAndPassword(login, password);
		if (user != null) {
			session.setAttribute("user", user);
			cartService.createNewCart();
		}
		return user;
	}

	public User signUpUser(String login,  String name,
			 String password,  String surname,  String phone) {
		User user = new User();
		user.setLogin(login);
		user.setName(name);
		user.setPassword(password);
		user.setSurname(surname);
		user.setTelephone(phone);
		user.setUserType(userTypeDao.getOne(2));
		return userDao.save(user);
	}

	public boolean validateLogin(String login) {
		return userDao.findByLogin(login) == null;
	}

	public void signOut() {
		session.removeAttribute("user");
		cartService.createNewCart();
	}

	public User getUser() {
		return (User) session.getAttribute("user");
	}
}
