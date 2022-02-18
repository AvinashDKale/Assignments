package com.library.LMS.services;

import java.util.List;

import com.library.LMS.model.Book;

public interface BookService {
	public Book saveBook(Book book);
	public Book updateBook(Book book);
	public List<Book> findAllBook();
	public void deleteBook(int ID);

}
