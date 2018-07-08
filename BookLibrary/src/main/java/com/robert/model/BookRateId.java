package com.robert.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class BookRateId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "book_id", insertable = false, updatable = false)
	private int bookId;

	@Column(name = "user_id", insertable = false, updatable = false)
	private int userId;

	public BookRateId() {
	}

	public BookRateId(int bookId, int userId) {
		this.bookId = bookId;
		this.userId = userId;
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BookRateId)) {
			return false;
		}
		BookRateId castOther = (BookRateId) other;
		return (this.bookId == castOther.bookId) && (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.bookId;
		hash = hash * prime + this.userId;

		return hash;
	}
}