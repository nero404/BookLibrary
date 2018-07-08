package com.robert.service;
//r
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.dao.UserDao;
import com.robert.model.User;

@Service
public class UserService {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDao userDao;

	@Autowired
	CartService cartService;

	public User signIn(String login, String password) {
		User user = userDao.findByLoginAndPassword(login, password);

		if (user != null) {
			session.setAttribute("user", user);
			cartService.createNewCart();
		}
		return user;
	}
	
	public User insertUser(User user) {
		return userDao.save(user);
	}
	
	public boolean validateLogin(String login) {
		if (userDao.findByLogin(login) != null)
			return false;
		else
			return true;
	}


	public void signOut() {
		session.removeAttribute("user");
		cartService.createNewCart();
	}

	public User getUser() {
		return (User) session.getAttribute("user");
	}
}
