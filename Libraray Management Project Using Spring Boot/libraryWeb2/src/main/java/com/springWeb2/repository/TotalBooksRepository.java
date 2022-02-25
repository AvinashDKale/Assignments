package com.springWeb2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springWeb2.entity.TotalBooks;

@Repository
public interface TotalBooksRepository extends CrudRepository<TotalBooks, Integer> {
    
}
