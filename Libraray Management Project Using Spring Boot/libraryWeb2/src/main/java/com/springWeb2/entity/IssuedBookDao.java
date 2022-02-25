package com.springWeb2.entity;

import com.opencsv.bean.CsvBindByName;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issued_books_table")
public class IssuedBookDao {
    @Id
    @Column(name = "Book_id")
    private int id;
    
    @Column(name = "Title")
    @CsvBindByName(column = "Title")
    private String title;
    
    @Column(name = "Author")
    @CsvBindByName(column = "Author")
    private String author;
    
    @Column(name = "Cost")
    private double cost;
    
    @Column(name = "Issued_date")
    @CsvBindByName(column = "Issued Date")
    private LocalDate issued_date;
    
    @Column(name = "Return_date")
    @CsvBindByName(column = "Return Date")
    private LocalDate return_date;
    
    @Column(name = "Issued_by")
    private String issued_by;
    
    public IssuedBookDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public IssuedBookDao(int id, String title, String author, double cost, LocalDate issued_date, LocalDate return_date,
            String issued_by) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.issued_date = issued_date;
        this.return_date = return_date;
        this.issued_by = issued_by;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public double getCost() {
        return cost;
    }
    
    public LocalDate getIssued_date() {
        return issued_date;
    }
    
    public LocalDate getReturn_date() {
        return return_date;
    }
    
    public String getIssued_by() {
        return issued_by;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public void setIssued_date(LocalDate issued_date) {
        this.issued_date = issued_date;
    }
    
    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }
    
    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }
    
    @Override
    public String toString() {
        return "IssuedBookDao [id=" + id + ", title=" + title + ", author=" + author + ", cost=" + cost
                + ", issued_date=" + issued_date + ", return_date=" + return_date + ", issued_by=" + issued_by + "]";
    }
    
}
