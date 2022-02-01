package com.librarymanagement.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.librarymanagement.library.model.Book;
import com.librarymanagement.library.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@GetMapping("/")
	public String viewHomePage(Model model){
		
		model.addAttribute("listBooks",bookservice.getAllBooks());
		return "index";
	}
	@GetMapping("/showNewBookForm")
	public String showNewBookForm(Model model){
	Book book =new Book();
	model.addAttribute("book",book);
	return"new_book";

	}
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book")Book book){
		bookservice.saveBook(book);
		return "redirect:/";

	}
}
