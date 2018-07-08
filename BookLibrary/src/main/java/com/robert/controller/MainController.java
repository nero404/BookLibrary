package com.robert.controller;
//r

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.robert.model.Book;
import com.robert.service.BookService;

@Controller
public class MainController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {

		List<Book> top15 = bookService.findTop15();

		model.addAttribute("top15List", top15);

		return new ModelAndView("/index", model);
	}

}
