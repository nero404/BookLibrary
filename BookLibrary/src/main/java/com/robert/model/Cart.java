package com.robert.model;


import java.util.ArrayList;
import java.util.List;

public class Cart {
	List<Book> books = new ArrayList<>();
	int numberOfBooks = 0;
	
	public void addBook(Book book) {
		boolean newBook = true;
		for (Book scbook : books) {
			if (book.getId() == scbook.getId()) {
				newBook = false;
			}
		}

		if (newBook) {
			books.add(book);
			numberOfBooks++;
		}
	}

	public void removeBook(Book book) {
		Book temp = null;
		for (Book scbook : books) {
			if (scbook.getId() == book.getId()) {
				temp = scbook;
				break;
			}
		}

		if (temp != null) {
			books.remove(temp);
			numberOfBooks--;
		}
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public List<Book> getBooks() {
		return books;
	}
}
