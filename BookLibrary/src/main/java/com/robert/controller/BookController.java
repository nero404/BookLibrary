package com.robert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.robert.model.Book;
import com.robert.model.User;
import com.robert.service.BookService;
import com.robert.service.CategoryService;
import com.robert.service.UserBorrowService;
import com.robert.service.UserService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	UserBorrowService userBorrowService;

	@RequestMapping(value = "/rateBook", method = RequestMethod.GET)
	public ModelAndView rateBook(@RequestParam int rate, @RequestParam int bookId, ModelMap model) {
		Book book = (Book) bookService.findById(bookId);
		User user = (User) userService.getUser();
		bookService.addBookRate(book, user, rate);
		bookService.avgRateBook(bookId);

		return new ModelAndView("redirect:/bookView/" + bookId, model);

	}

	@RequestMapping(value = "searchBooksView", method = RequestMethod.GET)
	public String searchBooksView() {
		return "/searchBooksView";
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam int bookId, ModelMap model) {
		bookService.deleteBook(bookId);
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = "/bookView/{bookId}", method = RequestMethod.GET)
	public ModelAndView bookView(@PathVariable int bookId, ModelMap model) {
		Book book = (Book) bookService.findById(bookId);
		boolean userRate = bookService.checkIfBookHasUserRate(bookId);
		model.addAttribute("userRate", userRate);

		model.addAttribute("book", book);

		return new ModelAndView("/bookView", model);

	}

	@RequestMapping(value = "/findBook", method = RequestMethod.GET)
	public ModelAndView findBook(@RequestParam String title, @RequestParam String parametr, ModelMap model) {

		if (parametr.equals("title")) {
			List<Book> books = (List<Book>) bookService.findByTitleContaining(title);
			model.addAttribute("selectedBook", books);
			return new ModelAndView("/searchBooksView", model);
		} else if (parametr.equals("author")) {
			List<Book> books = (List<Book>) bookService.findByAuthorContaining(title);
			model.addAttribute("selectedBook", books);
			return new ModelAndView("/searchBooksView", model);

		} else
			return new ModelAndView("/", model);
	}

	@RequestMapping(value = "updateBookView/{bookId}")
	public ModelAndView updateBookView(@PathVariable int bookId, ModelMap model) {
		Book book = bookService.findById(bookId);
		model.addAttribute("book", book);
		return new ModelAndView("/updateBookView", model);
	}

	@RequestMapping(value = "/addBookCrud", method = RequestMethod.GET)
	public ModelAndView addBook(@RequestParam String title, @RequestParam String author, @RequestParam String isbn,
			@RequestParam Integer amount, @RequestParam Integer categoryid, @RequestParam String description) {

		bookService.addBook(title, author, isbn, amount, categoryid, description);

		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
	public ModelAndView updateBook(@RequestParam Integer bookId, @RequestParam String title,
			@RequestParam String author, @RequestParam String isbn, @RequestParam int amount,
			@RequestParam Integer categoryId, @RequestParam String description, Model model) {
		Book bookToUpdate = bookService.findById(bookId);
		bookToUpdate.setTitle(title);
		bookToUpdate.setAuthor(author);
		bookToUpdate.setIsbn(isbn);
		bookToUpdate.setAmount(amount);
		bookToUpdate.setCategory(categoryService.findById(categoryId));
		bookToUpdate.setDescription(description);
		bookService.updateBook(bookToUpdate);

		return new ModelAndView("redirect:/index");

	}

	@RequestMapping(value = "/borrowBooks", method = RequestMethod.GET)
	public String borrowBooksView() {
		User user = (User) userService.getUser();
		userBorrowService.borrowBooks(user);

		return "/confirmView";
	}

	@RequestMapping(value = "/addBookView", method = RequestMethod.GET)
	public String addBookView() {

		return "/addBookView";
	}

}
