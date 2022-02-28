package com.springWeb2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springWeb2.entity.TotalBooks;
import com.springWeb2.repository.TotalBooksRepository;

@Service
public class TotalBooksServiceImpl implements TotalBooksServiceInterface {
    
    @Autowired
    TotalBooksRepository totalbooks;
    
    @Override
    public void saveTitle(TotalBooks total) {
        totalbooks.save(total);
        
    }
    
    @Override
    public void deleteTotalBooks(int id) {
        totalbooks.deleteById(id);
        
    }
    
    public TotalBooks getBooksById(int id) {
        return totalbooks.findById(id).get();
    }
    
}
