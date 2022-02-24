package com.springWeb2.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;
import com.springWeb2.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/issuedbooks")
public class IssuedController {
    
    @Autowired
    private IssuedServiceImpl issuedService;
    
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    private ReportService reportService;
    
    @GetMapping("/get/all")
    public List<IssuedBookDao> getIssuedBookList() {
        return (List<IssuedBookDao>) issuedService.findAllBooks();
    }
    
    @GetMapping("/issue/{id}")
    public BookDao addIssuedBook(@PathVariable int id) {
        BookDao book = libraryServiceImpl.getBookById(id);
        LocalDate date = LocalDate.now();
        IssuedBookDao IBook = new IssuedBookDao();
        IBook.setId(book.getId());
        IBook.setTitle(book.getTitle());
        IBook.setAuthor(book.getAuthor());
        IBook.setIssued_date(date);
        IBook.setReturn_date(date.plusDays(10));
        issuedService.saveBook(IBook);
        book.setStatus("Issued");
        libraryServiceImpl.saveBook(book);
        return book;
    }
    
    @GetMapping("/return/{id}")
    public BookDao deleteBook(@PathVariable int id) {
        issuedService.deleteBook(id);
        BookDao book = libraryServiceImpl.getBookById(id);
        String bookName = book.getTitle();
        book.setStatus("not issued");
        libraryServiceImpl.saveBook(book);
        return book;
    }
    
    @PostMapping("/report")
    public void generateAdvanceReport(@RequestParam(value = "reportName") String reportName,
            @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate,
            HttpServletResponse response) throws JRException, IOException {
        System.out.println(startDate + endDate);
        reportService.exportAdvanceReport(response, startDate, endDate, reportName);
    }
    
}
