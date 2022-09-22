package com.example.JaniBookstore.domain;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long book_id;
	private String book_title, book_author;
	private int book_isbn;
	private float book_price;
	private int book_year;

	
	
	
	public Book(String book_title, String book_author, int book_isbn, float book_price, int book_year) {
		super();
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_isbn = book_isbn;
		this.book_price = book_price;
		this.book_year = book_year;
	}
	
	public Book() {}



	public long getBook_id() {
		return book_id;
	}



	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}



	public String getBook_title() {
		return book_title;
	}



	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}



	public String getBook_author() {
		return book_author;
	}



	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}



	public int getBook_isbn() {
		return book_isbn;
	}



	public void setBook_isbn(int book_isbn) {
		this.book_isbn = book_isbn;
	}



	public float getBook_price() {
		return book_price;
	}



	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}



	public int getBook_year() {
		return book_year;
	}



	public void setBook_year(int book_year) {
		this.book_year = book_year;
	}



	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_title=" + book_title + ", book_author=" + book_author
				+ ", book_isbn=" + book_isbn + ", book_price=" + book_price + ", book_year=" + book_year + "]";
	}



	



	
	
	

}
