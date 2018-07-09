package com.robert.model;

import javax.persistence.*;

@Entity(name = "BookRate")
@Table(name = "book_rate")
public class BookRate {

	@EmbeddedId
	private BookRateId id;
	public BookRate() {
	}

	public BookRate(Book book, User user, int rate) {
		this.book = book;
		this.user = user;
		this.rate = rate;
		this.id = new BookRateId(book.getId(), user.getId());
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("bookId")
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	private User user;

	@Column(name = "rate")
	private int rate;

	public BookRateId getId() {
		return this.id;
	}

	public void setId(BookRateId id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}