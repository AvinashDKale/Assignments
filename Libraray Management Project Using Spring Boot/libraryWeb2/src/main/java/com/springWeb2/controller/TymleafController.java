package com.springWeb2.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.messeges.Messege;
import com.springWeb2.repository.IssuedRepository;
import com.springWeb2.repository.TotalBooksRepository;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;

@Controller
public class TymleafController {
    
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    TotalBooksRepository totalbook;
    
    @Autowired
    private IssuedServiceImpl issuedServiceImpl;
    
    @Autowired
    private IssuedRepository issuedrepository;
    
    @GetMapping(value = "/")
    public String viewHomePage(Model model, HttpServletRequest request, HttpSession session) {
        model.addAttribute("booksList", libraryServiceImpl.findAllBooks());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"));
        if (hasUserRole) {
            return "index";
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();
            List<IssuedBookDao> rawList = issuedrepository.findByIssuedFor(username);
            
            int count = 0;
            String msgst = "";
            for (IssuedBookDao book : rawList) {
                Messege msg = new Messege();
                LocalDate tempDate = book.getReturn_date();
                int p2 = (int) ChronoUnit.DAYS.between(LocalDate.now(), tempDate);
                
                if (p2 <= 10) {
                    String dys = String.valueOf(p2);
                    count = count + 1;
                    msgst = msgst + "remaining  " + dys + " days to return ' " + book.getTitle() + " ' book  ";
                    
                    msg.setContent(msgst);
                    
                    session.setAttribute("messege", msg);
                }
            }
        }
        
        return "index2";
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
        book.setStatus("not issued");
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
        issuedServiceImpl.deleteBook(id);
        
        return "redirect:/";
    }
    
    @GetMapping("/regiter")
    public String register() {
        
        return "regiter";
    }
}
