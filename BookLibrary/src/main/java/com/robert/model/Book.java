package com.robert.model;
//r

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Book")
@Table(name = "book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int amount;
	private String author;

	@Column(name = "data_added")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAdded;

	private String isbn;
	private String title;
	private int rate;
	private String description;

	@ManyToOne
	private Category category;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
	private List<UserBorrow> userBorrows;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookRate> usersRates = new ArrayList<>();

	public List<BookRate> getUsersRates() {
		return usersRates;
	}

	public void setUsersRates(List<BookRate> usersRates) {
		this.usersRates = usersRates;
	}

	public Book() {
	}

	/*
	 * public void removeBookRate(User user) { for (Iterator<BookRate> iterator =
	 * usersRates.iterator(); iterator.hasNext();) { BookRate bookRate =
	 * iterator.next(); if (bookRate.getBook().equals(this) &&
	 * bookRate.getUser().equals(user)) { iterator.remove();
	 * bookRate.getUser().getBooksRates().remove(bookRate); bookRate.setBook(null);
	 * bookRate.setUser(null); } } }
	 */

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDataAdded() {
		return this.dataAdded;
	}

	public void setDataAdded(Date dataAdded) {
		this.dataAdded = dataAdded;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<UserBorrow> getUserBorrows() {
		return this.userBorrows;
	}

	public void decrementAmount() {
		amount--;
	}

	public void setUserBorrows(List<UserBorrow> userBorrows) {
		this.userBorrows = userBorrows;
	}

	public List<BookRate> getRates() {
		return usersRates;
	}

	public void setRates(List<BookRate> rates) {
		this.usersRates = rates;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}