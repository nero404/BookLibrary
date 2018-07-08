package com.robert.service;

//r
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.robert.dao.BookDao;
import com.robert.dao.BookRateDao;
import com.robert.dao.UserDao;
import com.robert.model.Book;
import com.robert.model.BookRate;
import com.robert.model.Category;
import com.robert.model.User;



@Service
public class BookService {

	
	@Autowired
	UserService userService;
	
	@Autowired
	BookDao bookDao;

	@Autowired
	BookRateDao bookRateDao;

	public List<Book> findByTitleContaining(String title) {
		return bookDao.findByTitleContaining(title);
	}

	public Book findById(int id) {
		return bookDao.findOne(id);
	}

	public List<Book> findByAuthorContaining(String author) {
		return bookDao.findByAuthorContaining(author);
	}

	public List<Book> findByIsbnContaining(String isbn) {
		return bookDao.findByIsbnContaining(isbn);
	}

	public boolean addBookRate(Book book, User user, int rate) {
		if (validateRate(book.getId(), user.getId()) == false)
			return false;

		BookRate bookRate = new BookRate(book, user, rate);
		bookRateDao.save(bookRate);
		int newAvgRate = avgRateBook(book.getId());

		book.setRate(newAvgRate);

		bookDao.save(book);

		return true;
	}

	private boolean validateRate(int bookId, int userId) {
		BookRate bookRate = bookRateDao.FindByBookIdAndUserId(bookId, userId);
		if (bookRate != null)
			return false;
		else
			return true;
	}
	
	public boolean checkIfBookHasUserRate(int bookId) {

		User user = userService.getUser();
		Book book = bookDao.findOne(bookId);

		return !validateRate(book.getId(), user.getId());
	}
	
	

	public int avgRateBook(int bookId) {
		List<BookRate> bookRateList = bookRateDao.FindByBookId(bookId);

		if (bookRateList != null) {
			int sumRates = 0;
			int countRates = 0;

			for (BookRate bookRate : bookRateList) {
				sumRates += bookRate.getRate();
				countRates++;

			}
			int newAverageRate = sumRates / countRates;
			return newAverageRate;
		} else {
			return 0;
		}
	}

	public boolean addBook(String title, String author, String isbn, Integer amount, Integer categoryid, String description) {

		Category category = new Category();
		category.setId(categoryid);
		Book newBook = new Book();
		newBook.setAmount(amount);
		
		newBook.setAuthor(author);
		newBook.setIsbn(isbn);
		newBook.setDataAdded(new Date());
		newBook.setCategory(category);
		newBook.setTitle(title);
		newBook.setDescription(description);

		Book book = bookDao.save(newBook);

		if (book != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void updateBook(Book book) {
		bookDao.save(book);
	}
	
	public void deleteBook(int bookId) {
		Book bookToDelete = bookDao.findOne(bookId);
		bookDao.delete(bookToDelete);
		
	}
	
	public void updateBook() {
		
		
	}
	
	public List<Book> findTop15(){
		return bookDao.findTop15(new PageRequest(0, 14));
	}
	
	

}
