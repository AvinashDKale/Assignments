package com.librarymanagement.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get book from the service
		Book book = bookservice.getBookById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("book", book);
		return "update_book";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.bookservice.deleteBookById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Book> page = bookservice.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Book> listBooks = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
	
		model.addAttribute("listBooks", listBooks);
		return "index";
	}

}
