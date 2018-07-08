package com.robert.controller;
//r

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.robert.dao.BookDao;
import com.robert.model.Book;
import com.robert.model.Cart;
import com.robert.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;

	@Autowired
	BookDao bookService;

	@RequestMapping("/cartView")
	public ModelAndView goToCartView(ModelMap model) {
		model.addAttribute("cart", cartService.getCart());
		return new ModelAndView("/cartView", model);
	}

	@RequestMapping(value = "/removeBookFromCart", method = RequestMethod.GET)
	public ModelAndView removeBookFromCart(@RequestParam int bookId, ModelMap model) {
		Book book = bookService.findOne(bookId);
		Cart cart = cartService.getCart();
		cart.removeBook(book);

		return new ModelAndView("/cartView", model);
	}

	@RequestMapping(value = "/addBookToCart", method = RequestMethod.GET)
	public ModelAndView addBook(@RequestParam int bookId, ModelMap model) {
		Book book = bookService.findOne(bookId);
		if (book.getAmount() > 0) {
			Cart cart = cartService.getCart();
			cart.addBook(book);
		}

		return new ModelAndView("/cartView", model);
	}
}
