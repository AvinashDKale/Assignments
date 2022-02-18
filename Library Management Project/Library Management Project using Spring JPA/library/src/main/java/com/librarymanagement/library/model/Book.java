package com.librarymanagement.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="title")
	
	private String title;
	
	@Column(name="author")
	private String author;
	
	@Column(name="publication")
	private String publication;
	
	@Column(name="edition")
	private String edition;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
}
