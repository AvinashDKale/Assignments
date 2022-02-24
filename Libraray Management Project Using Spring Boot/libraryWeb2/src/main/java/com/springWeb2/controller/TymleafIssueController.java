package com.springWeb2.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;

@Controller
public class TymleafIssueController {
    @Autowired
    private IssuedServiceImpl issuedServiceImpl;
    
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @GetMapping("issuedbook/add/{id}")
    public String addIssuedBook(@PathVariable int id,RedirectAttributes redirAttrs) {
        BookDao book = libraryServiceImpl.getBookById(id);
       String messege="";
        int quantity=book.getQuantity();
        
       if(quantity==0) {
           messege="all books of"+book.getTitle()+" are Issued";
           System.out.println(messege);
           redirAttrs.addFlashAttribute("error", messege);
       } 
       else {
           book.setQuantity(quantity-1);
           libraryServiceImpl.saveBook(book);
       }
        
        LocalDate date = LocalDate.now();
        IssuedBookDao Ibook = new IssuedBookDao(book.getId(), book.getTitle(), book.getAuthor(), book.getCost(), date,
                date.plusDays(10));
        issuedServiceImpl.saveBook(Ibook);
        book.setStatus("Issued");
        libraryServiceImpl.saveBook(book);
        return "redirect:/";
    }
    
    @GetMapping("/issuedbook/get/all")
    public String showIssuedBooks(Model model) {
        model.addAttribute("listBooks", issuedServiceImpl.findAllBooks());
        return "issued_books";
    }
    
    @GetMapping("/issuedbook/delete/{id}")
    public String deleteIssuedBook(@PathVariable(value = "id") int id) {
        BookDao book = libraryServiceImpl.getBookById(id);
        int quantity=book.getQuantity();
        book.setStatus("not issued");
        book.setQuantity(quantity+1);
        libraryServiceImpl.saveBook(book);
        if(quantity==1  ) {
        this.issuedServiceImpl.deleteBook(id);}
        
        return "redirect:/issuedbook/get/all";
    }
}
