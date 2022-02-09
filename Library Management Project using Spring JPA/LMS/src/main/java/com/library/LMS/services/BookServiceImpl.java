package com.library.LMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.LMS.model.Book;
import com.library.LMS.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookrepository;
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookrepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookrepository.save(book);
	}

	@Override
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		return (List<Book>) bookrepository.findAll();
	}

	@Override
	public void deleteBook(int id) {
	 bookrepository.deleteById(id);
		
	}

}
