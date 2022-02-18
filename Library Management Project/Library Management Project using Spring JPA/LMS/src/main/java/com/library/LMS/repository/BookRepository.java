package com.library.LMS.repository;

import org.springframework.stereotype.Repository;

import com.library.LMS.model.Book;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface BookRepository extends CrudRepository<Book,Integer>{

	

}
