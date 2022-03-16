package com.qa.bookcase.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Book {
	
	//Creating Book attributes
	//book Id column which is auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//book title 
	@Column(unique = true, nullable = false)
	private String title;
	
	//book author name
	@Column
	private String author;
	
	//book type e.g fiction, documentary
	@Column
	private String genre;
	
	//book author award granted
	@Column
	private String award;
	
	//number of pages
	@Column
	@Min(1)
	@Max(1000)
	private int pages;
	
	//Creating class constructors
	public Book() {}

	public Book(String title, String author, String genre, String award, @Min(1) @Max(1000) int pages) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.award = award;
		this.pages = pages;
	}
	
	// constructor for testing purposes 
	public Book(long id, String title, String author, String genre, String award, @Min(1) @Max(1000) int pages) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.award = award;
		this.pages = pages;
	}

	//Creating Getters and Setters
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", award=" + award
				+ ", pages=" + pages + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, award, genre, pages, title);
	}

	//For testing, when verifying and comparing objects
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(award, other.award)
				&& Objects.equals(genre, other.genre) && pages == other.pages
				&& Objects.equals(title, other.title);
	}

	
	
}
