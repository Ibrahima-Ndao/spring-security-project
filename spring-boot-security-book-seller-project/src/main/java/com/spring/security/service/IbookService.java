package com.spring.security.service;

import java.util.List;

import com.spring.security.model.Book;

public interface IbookService {

	Book saveBook(Book book);

	void delete(Long id);

	List<Book> findAllBooks();
	
}
