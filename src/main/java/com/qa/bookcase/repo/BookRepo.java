package com.qa.bookcase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.bookcase.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

}
