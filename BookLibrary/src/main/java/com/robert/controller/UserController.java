package com.robert.controller;
//r

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.robert.dao.UserTypeDao;
import com.robert.model.User;

import com.robert.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/signIn")
	public String signIn() {
		return "/signInView";
	}

	@RequestMapping("/signUp")
	public String signUp() {
		return "/signUpView";
	}

	@RequestMapping("/signIn/validate")
	public ModelAndView validateSignIn(@RequestParam String login, @RequestParam String password, ModelMap model) {
		User user = userService.signIn(login, password);
		if (user != null)
			return new ModelAndView("redirect:/index");
		else
			return new ModelAndView("/signIn");
	}

	@RequestMapping("/signOut")
	public String signOut() {
		userService.signOut();
		return "redirect:/index";
	}

	@RequestMapping("/signUp/validate")
	public ModelAndView validateSignIn(@RequestParam String login, @RequestParam String name,
			@RequestParam String password, @RequestParam String surname, @RequestParam String phone, ModelMap model) {
		if (userService.validateLogin(login) == true) {
			User user = userService.signUpUser(login, name, password, surname, phone);
			if (user == null)
				return new ModelAndView("/signUp");
		}
		return new ModelAndView("redirect:/index");

	}

	@RequestMapping(value = "/userInfoView", method = RequestMethod.GET)
	public String infoView() {
		return "/userInfoView";
	}

	@RequestMapping(value = "/ownOrdersView", method = RequestMethod.GET)
	public String ownOrders() {
		return "ownOrdersView";
	}

}
