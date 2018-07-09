package com.robert.model;

//r
import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String login;
	private String name;
	private String password;

	@Column(name = "sure_name")
	private String sureName;
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "user_type_id")
	private UserType userType;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<UserBorrow> userBorrows;

	public User() {

	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookRate> booksRates = new ArrayList<>();

	public List<BookRate> getBooksRates() {
		return booksRates;
	}

	public void setBooksRates(List<BookRate> bookRates) {
		this.booksRates = bookRates;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSureName() {
		return this.sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<UserBorrow> getUserBorrows() {
		return this.userBorrows;
	}

	public void setUserBorrows(List<UserBorrow> userBorrows) {
		this.userBorrows = userBorrows;
	}

	public UserBorrow addUserBorrow(UserBorrow userBorrow) {
		getUserBorrows().add(userBorrow);
		userBorrow.setUser(this);

		return userBorrow;
	}

	public UserBorrow removeUserBorrow(UserBorrow userBorrow) {
		getUserBorrows().remove(userBorrow);
		userBorrow.setUser(null);

		return userBorrow;
	}

}