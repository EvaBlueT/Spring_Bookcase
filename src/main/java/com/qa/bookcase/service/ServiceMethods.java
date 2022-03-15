package com.qa.bookcase.service;

import java.util.List;

public interface ServiceMethods<T> {
	
	//CRUD Methods, T == Book
	//Create
	T create(T book);
	
	//Read All
	List<T> readAll();
	
	//Read By Id
	T readById(long id);
	
	
	//Update
	T update(long id, T book);
	
	//Delete
	boolean delete(long id);

}
