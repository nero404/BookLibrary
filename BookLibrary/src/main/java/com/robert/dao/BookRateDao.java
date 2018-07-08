package com.robert.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.robert.model.BookRate;

public interface BookRateDao extends JpaRepository<BookRate, Integer> {

	@Query("select b from BookRate b where b.book.id = :bookId")
	List<BookRate> FindByBookId(@Param("bookId") int bookId);

	@Query("select b from BookRate b where b.book.id = :bookId and b.user.id = :userId")
	BookRate FindByBookIdAndUserId(@Param("bookId") int bookId, @Param("userId") int userId);

}
