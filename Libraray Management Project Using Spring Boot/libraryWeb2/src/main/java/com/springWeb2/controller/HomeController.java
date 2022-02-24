package com.springWeb2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.LibraryServiceImpl;

@RestController
@RequestMapping("/books")
public class HomeController {
    
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    @Autowired
    private LibraryServiceImpl libraryService;
    
    @GetMapping("/get/all")
    public ResponseEntity<List<BookDao>> getBookList() {
        
        List<BookDao> bookList = libraryService.findAllBooks();
        return new ResponseEntity<List<BookDao>>(bookList, HttpStatus.OK);
    }
    
    @GetMapping("/get/{id}")
    public BookDao getBookById(@PathVariable("id") int id) {
        BookDao book = libraryService.getBookById(id);
        return book;
    }
    
    @PostMapping(value = "/save")
    public BookDao saveBook(@ModelAttribute("book") BookDao book) {
        libraryService.saveBook(book);
        return book;
    }
    
    @PutMapping(value = "/update")
    public BookDao updateBook(@ModelAttribute("book") BookDao book) {
        libraryService.saveBook(book);
        return book;
    }
    
    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam int id) {
        BookDao book = libraryService.getBookById(id);
        String bookName = book.getTitle();
        libraryService.deleteBook(id);
        
        return "book " + bookName + " deleted";
    }
    
}
