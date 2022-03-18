package com.qa.bookcase.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.bookcase.entity.Book;



//Boots the application context
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //Creates the MockMcc object
@ActiveProfiles("test")
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:book-schema.sql", "classpath:book-data.sql"})
public class BookControllerIntegrationTest {

		@Autowired //Tells Spring to insert this object into the class
		private MockMvc mvc;
		
		@Autowired
		private ObjectMapper mapper;
		
		@Test
		public void testCreate() throws Exception {
			//URL body method headers
			Book testBook = new Book("Swiat na rozdrozu", "Marcin Popkiewicz","Social sciences", "Economicus", 567);
			String testBookAsJSON = this.mapper.writeValueAsString(testBook);
			RequestBuilder req = post("/book/create").content(testBookAsJSON).contentType(MediaType.APPLICATION_JSON);
			
			Book testSavedBook = new Book(2, "Swiat na rozdrozu", "Marcin Popkiewicz","Social sciences", "Economicus", 567);
			String testSaveBookAsJSON = this.mapper.writeValueAsString(testSavedBook);
			ResultMatcher checkStatus = status().isCreated();
			ResultMatcher checkBody = content().json(testSaveBookAsJSON);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		@Test
			public void testCreate2() throws Exception {
			//URL body method headers
			Book testBook = new Book("The Books of Jacob", "Olga Tokarczuk","Historical Novel", "Nobel Prize", 912);
			String testBookAsJSON = this.mapper.writeValueAsString(testBook);
			RequestBuilder req = post("/book/create").content(testBookAsJSON).contentType(MediaType.APPLICATION_JSON);
			
			Book testSavedBook = new Book(2, "The Books of Jacob", "Olga Tokarczuk","Historical Novel", "Nobel Prize", 912);
			String testSaveBookAsJSON = this.mapper.writeValueAsString(testSavedBook);
			ResultMatcher checkStatus = status().isCreated();
			ResultMatcher checkBody = content().json(testSaveBookAsJSON);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
}
		@Test
		public void testReadById() throws Exception {
			RequestBuilder req = get("/book/readById/1");
			
			ResultMatcher checkStatus = status().isOk();
			
			Book saveBook = new Book(1, "Brick Lane", "Monica Ali", "Novel", "Young British", 496);
			String saveBookAsJSON = this.mapper.writeValueAsString(saveBook);
			
			ResultMatcher checkBody = content().json(saveBookAsJSON);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		public void testReadAll() throws Exception {
			Book entry = new Book(1L,"Brick Lane", "Monica Ali", "Novel", "Young British", 496);
			List<Book> books = new ArrayList<>();
			books.add(entry);
			String bookOutputJson = this.mapper.writeValueAsString(books);
			
			this.mvc.perform(get("/book/readAll")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().json(bookOutputJson));
		}
		
}