package com.librarymanagement.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagement.library.model.Book;
import com.librarymanagement.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookrepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookrepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		this.bookrepository.save(book);
	}

	
}
