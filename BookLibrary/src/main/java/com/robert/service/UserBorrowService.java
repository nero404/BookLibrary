package com.robert.service;

//r
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.model.User;
import com.robert.model.UserBorrow;
import com.robert.dao.BookDao;
import com.robert.dao.BorrowDao;
import com.robert.dao.UserDao;
import com.robert.model.Book;
import com.robert.model.Cart;

@Service
public class UserBorrowService {

	@Autowired
	BorrowDao borrowDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CartService cartService;

	@Transactional
	public void borrowBooks(User user) {
		Cart cart = cartService.getCart();
		int numberOfBooks = cart.getNumberOfBooks();
		List<Book> books = cart.getBooks();
		UserBorrow borrow = new UserBorrow();
		borrow.setAmount(numberOfBooks);
		borrow.setUser(user);
		borrow.setDate(new Date());
		borrow.setBooks(books);
		user.getUserBorrows().add(borrow);
		for (Book book : books) {
			book.getUserBorrows().add(borrow);
			book.decrementAmount();
		}
		borrowDao.save(borrow);
		borrowDao.flush();
		userDao.flush();
		cartService.createNewCart();
	}
}
