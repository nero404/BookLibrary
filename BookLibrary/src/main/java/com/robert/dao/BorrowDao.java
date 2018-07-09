package com.robert.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robert.model.UserBorrow;

public interface BorrowDao extends JpaRepository<UserBorrow, Integer> {

}
