package com.librarymanagement.library.service;

import java.util.List;

import com.librarymanagement.library.model.*;
public interface BookService {
	

	List<Book>getAllBooks();
	void saveBook(Book book);
}
