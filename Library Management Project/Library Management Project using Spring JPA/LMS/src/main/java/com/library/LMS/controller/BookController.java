package com.library.LMS.controller;
import com.library.LMS.model.Book;
import com.library.LMS.services.BookServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class BookController {
	
	@Autowired
	private BookServiceImpl bookserviceimpl;
	
	@PostMapping(value="saveBook")
	public Book saveBook(@RequestBody Book book)
	{
		bookserviceimpl.saveBook(book);
		System.out.println(" Book Saved");
		return book;
	}
	
	@GetMapping(value="getAllBook")
	public List<Book>findAllBook()
	{
		return bookserviceimpl.findAllBook();	
	}
	
	@PutMapping(value="updatBook")
	public Book updateBook(@RequestBody Book book)
	{
		return bookserviceimpl.updateBook(book);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		return "Book Deleted";
	}
	

}
