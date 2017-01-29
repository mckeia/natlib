package com.ianmck.natlib.model;

public class Book {

	Integer id;
	String author;
	String title;
	String isbn;

	public Book(Integer id,String author,String title,String isbn) {
		this.id = id;
		this.author = author;	
		this.title = title;
		this.isbn = isbn;		
	}

	public Book() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn="+ isbn +"]";
	}

}
