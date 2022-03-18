package com.qa.bookcase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bookcase.entity.Book;
import com.qa.bookcase.service.BookService;



@RestController
@RequestMapping("/book")
public class BookController {
	
	private BookService service;
	
	@Autowired  //Instructs Spring to Insert the BookService object
	public BookController(BookService service) {
		this.service = service;
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return new ResponseEntity<Book>(this.service.create(book), HttpStatus.CREATED);
		
	}
	
	//Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<Book>> readAllBooks(){
		return new ResponseEntity<List<Book>>(this.service.readAll(), HttpStatus.OK);
	}
	
	
	//Read By Id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Book> readById(@PathVariable long id){
		return new ResponseEntity<Book>(this.service.readById(id),HttpStatus.OK);
	}
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book){
		return new ResponseEntity<Book>(this.service.update(id, book),HttpStatus.ACCEPTED);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable long id){
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT):
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
