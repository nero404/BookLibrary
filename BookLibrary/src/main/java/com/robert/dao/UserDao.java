package com.robert.dao;

//r
import org.springframework.data.jpa.repository.JpaRepository;

import com.robert.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByLoginAndPassword(String login, String password);

	User findByLogin(String login);

}
