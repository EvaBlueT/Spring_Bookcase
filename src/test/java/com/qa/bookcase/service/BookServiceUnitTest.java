package com.qa.bookcase.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.qa.bookcase.entity.Book;
import com.qa.bookcase.repo.BookRepo;

@SpringBootTest
public class BookServiceUnitTest {
	
	@Autowired
	private BookService service;
	
	//mocking the repository class
	@MockBean
	private BookRepo repo;
	
	@Test
	public void createBookTest() {
		Book input = new Book("Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496);
		Book output = new Book(1L, "Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496);
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	@Test
	public void readByIdTest() {
		Optional<Book> optionalOutput = Optional.of(new Book(1L, "Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496));
		Book output = new Book(1L, "Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496);
		
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		
		assertEquals(output, this.service.readById(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}
	@Test
	public void updateTest() {
		Book input = new Book("Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496);
		Optional<Book> optionalOutput = Optional.of(new Book(1L, "Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496));
		Book output = new Book(1L, "Brick Lane", "Monica Ali", "Novel", "Young British Novelist", 496);
		
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.update(Mockito.anyLong(), input));
	
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
		
		}
	@Test
	public void deleteTrueTest() {
				
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		assertTrue(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		
	}
	@Test
	public void deleteFalseTest() {
				
		Mockito.when(this.repo.existsById(1L)).thenReturn(true);
		assertFalse(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		
	}

}
