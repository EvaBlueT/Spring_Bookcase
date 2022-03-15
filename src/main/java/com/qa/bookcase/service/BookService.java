package com.qa.bookcase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.bookcase.entity.Book;
import com.qa.bookcase.repo.BookRepo;

@Service
public class BookService implements ServiceMethods<Book>{

	//Creating a variable of the type BookRepo to be able to access Repository methods 
	//cannot create and instantiate an object because BookRepo is an Interface
	private BookRepo repo;
	
	//Constructor
	public BookService(BookRepo repo) {
		this.repo = repo;
	}
	
	
	@Override
	public Book create(Book book) {
		return this.repo.save(book);
	}

	@Override
	public List<Book> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Book readById(long id) {
		Optional<Book> getBook = this.repo.findById(id);
		if(getBook.isPresent()) {
			return getBook.get();
		}
		return null;
	}

	@Override
	public Book update(long id, Book book) {
		Optional<Book> existingBook = this.repo.findById(id);
		if(existingBook.isPresent()) {
			Book exists = existingBook.get();
			exists.setTitle(book.getTitle());
			exists.setAuthor(book.getAuthor());
			exists.setGenre(book.getGenre());
			exists.setAward(book.getAward());
			exists.setPages(book.getPages());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	

}
