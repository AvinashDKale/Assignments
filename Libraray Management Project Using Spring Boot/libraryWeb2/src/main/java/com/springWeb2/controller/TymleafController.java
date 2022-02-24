package com.springWeb2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springWeb2.entity.BookDao;
import com.springWeb2.service.LibraryServiceImpl;

@Controller
public class TymleafController {
    
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @GetMapping(value = "/")
    public String viewHomePage(Model model) {
        model.addAttribute("booksList", libraryServiceImpl.findAllBooks());
        return "index";
    }
    
    @GetMapping(value = "/book/add")
    public String addBookForm(Model model) {
        BookDao book = new BookDao();
        model.addAttribute("book", book);
        return "new_book";
    }
    
    @GetMapping(value = "/book/search")
    public String searchBookForm() {
        
        return "searchPage";
    }
    
    @GetMapping(value = "/searchBook")
    public String searchBook(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("booksList", libraryServiceImpl.getByKeyword(keyword));
        } else {
            return "searchPage";
        }
        return "searchPage";
    }
    
    @PostMapping(value = "/book/save")
    public String saveBook(@ModelAttribute("book") BookDao book) {
        libraryServiceImpl.saveBook(book);
        return "redirect:/";
    }
    
    @GetMapping("/book/update/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {
        BookDao book = libraryServiceImpl.getBookById(id);
        model.addAttribute("book", book);
        return "update_book";
    }
    
    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        this.libraryServiceImpl.deleteBook(id);
        return "redirect:/";
    }
}