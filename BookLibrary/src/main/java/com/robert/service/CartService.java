package com.robert.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.model.Cart;

@Service
public class CartService {	

	@Autowired
	private HttpSession session;

	public Cart getCart() {
		Object cart = session.getAttribute("cart");
		if (cart != null) {
			return (Cart) cart;
		} else {
			Cart newCart = new Cart();
			session.setAttribute("cart", cart);
			return newCart;
		}
	}

	public void createNewCart() {
		session.setAttribute("cart", new Cart());
	}
}
