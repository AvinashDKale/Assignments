package com.springWeb2.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssueRequest;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.repository.IssueRequestRepository;
import com.springWeb2.repository.IssuedRepository;
import com.springWeb2.service.IssueRequestService;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;

@Controller
public class TymleafIssueController {
    @Autowired
    private IssuedServiceImpl issuedServiceImpl;
    
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    private IssueRequestRepository issueRequest;
    
    @Autowired
    private IssueRequestService issueRequestSerice;
    @Autowired
    private IssuedRepository issuedrepository;
    
    @GetMapping("issuedbook/add/{id}")
    public String addIssuedBook(@PathVariable int id) {
        
        BookDao book = libraryServiceImpl.getBookById(id);
        if (book.getStatus() == "Issued")
            libraryServiceImpl.saveBook(book);
        
        LocalDate date = LocalDate.now();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        System.out.println(username);
        IssueRequest issue = issueRequestSerice.getReuqestById(id);
        IssuedBookDao Ibook = new IssuedBookDao(book.getId(), book.getTitle(), book.getAuthor(), book.getCost(), date,
                date.plusDays(10), username, issue.getIssued_for());
        issuedServiceImpl.saveBook(Ibook);
        book.setStatus("Issued");
        libraryServiceImpl.saveBook(book);
        issueRequestSerice.deleteRequest(id);
        
        return "redirect:/";
    }
    
    @GetMapping("/issuedbook/get/all")
    public String showIssuedBooks(Model model) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"));
        
        if (hasUserRole) {
            model.addAttribute("listBooks", issuedServiceImpl.findAllBooks());
            return "issued_books";
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();
            System.out.println(username);
            model.addAttribute("listIsssuedBooks", issuedrepository.findByIssuedFor(username));
            System.out.println(issuedrepository.findByIssuedFor(username));
            return "issued_books_user";
        }
        
    }
    
    @GetMapping("/issuedbook/delete/{id}")
    public String deleteIssuedBook(@PathVariable(value = "id") int id, RedirectAttributes redirAttrs) {
        BookDao book = libraryServiceImpl.getBookById(id);
        
        book.setStatus("not issued");
        this.issuedServiceImpl.deleteBook(id);
        return "redirect:/issuedbook/get/all";
    }
    
    @GetMapping("/request/{id}")
    public String issueRequest(@PathVariable int id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        BookDao book = libraryServiceImpl.getBookById(id);
        if (book.getStatus() == "Issued") {
            return "redirect:/";
        } else {
            IssueRequest issue = new IssueRequest();
            issue.setId(book.getId());
            issue.setIssued_for(username);
            issueRequest.save(issue);
            book.setStatus("float..");
            libraryServiceImpl.saveBook(book);
            return "redirect:/";
        }
    }
    
    @GetMapping("/issuerequest")
    public String showIssueRequest(Model model) {
        model.addAttribute("issueRequests", issueRequestSerice.findAllRequests());
        
        return "issue_request";
    }
    
}
