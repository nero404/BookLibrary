package com.robert.dao;

//r
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.robert.model.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	public List<Book> findByTitleContaining(String title);

	public List<Book> findByAuthorContaining(String author);

	public List<Book> findByIsbnContaining(String isbn);

	@Query("select b from Book b order by b.rate desc")
	public List<Book> findTop15(Pageable pageable);

}
