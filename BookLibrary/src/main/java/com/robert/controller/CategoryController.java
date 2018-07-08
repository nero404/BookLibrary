package com.robert.controller;
//r

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.robert.model.Book;
import com.robert.model.Category;
import com.robert.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/categoryView/{categoryId}", method = RequestMethod.GET)
	public ModelAndView test(@PathVariable int categoryId, ModelMap model) {

		Category selectedCategory = categoryService.findById(categoryId);
		model.addAttribute("selectedCategory", selectedCategory);

		List<Book> categoryBooks = selectedCategory.getBooks();

		model.addAttribute("categoryBooks", categoryBooks);

		return new ModelAndView("/categoryView", model);
	}

	@RequestMapping("/categoriesView")
	public ModelAndView categoriesView(ModelMap model) {
		model.addAttribute("categories", categoryService.findAll());

		return new ModelAndView("/categoriesView", model);
	}

}
