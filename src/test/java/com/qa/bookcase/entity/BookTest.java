package com.qa.bookcase.entity;

import org.junit.jupiter.api.Test;


import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BookTest {
	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Book.class).usingGetClass().verify();
	}
	
	@Test
	public void getAndSetTest() {
		Book book = new Book();
		
		book.setId(1L);
		book.setAuthor("Monica Ali");
		book.setTitle("Brick Lane");
		book.setGenre("Novel");
		book.setPages(496);
		book.setAward("Young British Novelist");
				
		assertNotNull(book.getId());
		assertNotNull(book.getAuthor());
		assertNotNull(book.getTitle());
		assertNotNull(book.getGenre());
		assertNotNull(book.getPages());
		assertNotNull(book.getAward());
		
		assertEquals(book.getId(), 1L);
		assertEquals(book.getAuthor(), "Monica Ali");
		assertEquals(book.getTitle(), "Brick Lane");
		assertEquals(book.getGenre(), "Novel");
		assertEquals(book.getPages(), 496);
		assertEquals(book.getAward(), "Young British Novelist");
		
		
	}
	
	@Test
	public void allArgsConstructor() {
		Book book = new Book(1L, "Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496);
		
		assertNotNull(book.getId());
		assertNotNull(book.getAuthor());
		assertNotNull(book.getTitle());
		assertNotNull(book.getGenre());
		assertNotNull(book.getPages());
		assertNotNull(book.getAward());
		
		assertEquals(book.getId(), 1L);
		assertEquals(book.getAuthor(), "Monica Ali");
		assertEquals(book.getTitle(), "Brick Lane");
		assertEquals(book.getGenre(), "Novel");
		assertEquals(book.getPages(), 496);
		assertEquals(book.getAward(), "Young British Novelist");
	}
	@Test
	public void someArgsConstructor() {
		Book book = new Book("Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496);
		
		assertNotNull(book.getAuthor());
		assertNotNull(book.getTitle());
		assertNotNull(book.getGenre());
		assertNotNull(book.getPages());
		assertNotNull(book.getAward());
		
		assertEquals(book.getAuthor(), "Monica Ali");
		assertEquals(book.getTitle(), "Brick Lane");
		assertEquals(book.getGenre(), "Novel");
		assertEquals(book.getPages(), 496);
		assertEquals(book.getAward(), "Young British Novelist");
	}

}
