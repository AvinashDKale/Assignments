package com.librarymanagement.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

	@Override
	public Book getBookById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
