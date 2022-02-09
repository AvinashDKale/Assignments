package com.library.LMS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_table", catalog="book_database")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	private String author;
	private String publication;
	
	public Book(int id,String title,String author,String publication)
	{
		super();
		this.author=author;
		this.id=id;
		this.publication=publication;
		this.title=title;
		
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getPublication() 
	{
		return publication;
	}
	
	public void setPublication(String publication)
	{
		this.publication = publication;
	}
	

}
