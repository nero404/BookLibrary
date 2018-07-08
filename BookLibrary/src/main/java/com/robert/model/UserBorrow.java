package com.robert.model;
//r
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_borrow database table.
 * 
 */
@Entity
@Table(name="user_borrow")
@NamedQuery(name="UserBorrow.findAll", query="SELECT u FROM UserBorrow u")
public class UserBorrow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int amount;

	@Temporal(TemporalType.TIMESTAMP)
    private Date date;

	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="borrowed_book"
		, joinColumns={
			@JoinColumn(name="user_borrow_id", referencedColumnName = "id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="book_id", referencedColumnName = "id")
			}
		)
	private List<Book> books;

	
	@ManyToOne
	private User user;

	public UserBorrow() {
	}

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

	public Date getDate() {
		return this.date;
	}


	
	public void setDate(Date date) {
		this.date = date;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}