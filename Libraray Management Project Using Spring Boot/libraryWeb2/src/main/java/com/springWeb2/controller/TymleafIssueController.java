package com.springWeb2.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.entity.TotalBooks;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;
import com.springWeb2.service.TotalBooksServiceImpl;

@Controller
public class TymleafIssueController {
    @Autowired
    private IssuedServiceImpl issuedServiceImpl;
    
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    private TotalBooksServiceImpl totalBooksService;
    
    @GetMapping("issuedbook/add/{id}")
    public String addIssuedBook(@PathVariable int id, RedirectAttributes redirAttrs) {
        BookDao book = libraryServiceImpl.getBookById(id);
        if(book.getStatus()=="Issued")
        libraryServiceImpl.saveBook(book);
        
//        String messege = "";
//        int quantity = book.getQuantity();
//        
//        if (quantity == 0) {
//            messege = "all books of" + book.getTitle() + " are Issued";
//            System.out.println(messege);
//            redirAttrs.addFlashAttribute("error", messege);
//        } else {
//            book.setQuantity(quantity - 1);
//            libraryServiceImpl.saveBook(book);
//        }
//        
        LocalDate date = LocalDate.now();
        
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
          String username = ((UserDetails)principal).getUsername();
          System.out.println(username);
          IssuedBookDao Ibook = new IssuedBookDao(book.getId(), book.getTitle(), book.getAuthor(), book.getCost(), date,
                  date.plusDays(10), username);
          issuedServiceImpl.saveBook(Ibook);
          book.setStatus("Issued");
          libraryServiceImpl.saveBook(book);

        } else {
          String username = principal.toString();
          System.out.println(username);
          IssuedBookDao Ibook = new IssuedBookDao(book.getId(), book.getTitle(), book.getAuthor(), book.getCost(), date,
                  date.plusDays(10), username);
          issuedServiceImpl.saveBook(Ibook);
          book.setStatus("Issued");
          libraryServiceImpl.saveBook(book);

        }
       
        
        return "redirect:/";
    }
    
    @GetMapping("/issuedbook/get/all")
    public String showIssuedBooks(Model model) {
        model.addAttribute("listBooks", issuedServiceImpl.findAllBooks());
        return "issued_books";
    }
    
    @GetMapping("/issuedbook/delete/{id}")
    public String deleteIssuedBook(@PathVariable(value = "id") int id,RedirectAttributes redirAttrs) {
        BookDao book = libraryServiceImpl.getBookById(id);
//        TotalBooks total=totalBooksService.getBooksById(id);
//        int nBooks=total.getTotalBooks();
//        int quantity = book.getQuantity();
//        if(quantity<=nBooks) {
//        book.setStatus("not issued");
//        book.setQuantity(quantity + 1);
//        libraryServiceImpl.saveBook(book);
//       if(quantity== nBooks-1)this.issuedServiceImpl.deleteBook(id);
//        }
//        else {
//           String  messege = "all books of" + book.getTitle() + " are Returned";
//            System.out.println(messege);
//            redirAttrs.addFlashAttribute("error", messege);
//        }       
        book.setStatus("not issued");
        this.issuedServiceImpl.deleteBook(id);
        return "redirect:/issuedbook/get/all";
    }
}
