package com.librarymanagement.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.librarymanagement.library.model.Book;
import com.librarymanagement.library.repository.BookRepository;

public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookrepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookrepository.findAll();
	}

	
}
