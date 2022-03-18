package com.qa.bookcase.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.bookcase.controller.BookController;
import com.qa.bookcase.entity.Book;
import com.qa.bookcase.service.BookService;





@SpringBootTest
public class BookControllerUnitTest {
	
	@Autowired
	private BookController controller;
	
	@MockBean
	private BookService service;
	
	@Test
	public void createBookTest() {
		Book book = new Book("Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496);
		
		Mockito.when(this.service.create(book)).thenReturn(book);
		
		ResponseEntity<Book> response = new ResponseEntity<Book>(book, HttpStatus.CREATED);
		
		assertThat(response).isEqualTo(this.controller.createBook(book));
		
		Mockito.verify(this.service, times(1)).create(book);
		
		
	}
	

}
