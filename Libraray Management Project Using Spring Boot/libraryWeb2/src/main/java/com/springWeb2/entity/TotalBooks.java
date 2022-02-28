package com.springWeb2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "total_books")
public class TotalBooks {
    @Id
    @Column(name = "Book_id")
    private int id;
    
    @Column(name = "Title")
    private String title;
    
    @Column(name = "Books")
    private int totalBooks;
    
    public TotalBooks() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public TotalBooks(int id, String title, int totalBooks) {
        super();
        this.id = id;
        this.title = title;
        this.totalBooks = totalBooks;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getTotalBooks() {
        return totalBooks;
    }
    
    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }
    
    @Override
    public String toString() {
        return "TotalBooks [id=" + id + ", title=" + title + ", totalBooks=" + totalBooks + "]";
    }
    
}
