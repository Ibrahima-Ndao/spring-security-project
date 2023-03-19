package com.spring.security.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.model.Book;
import com.spring.security.repository.BookRepository;
import com.spring.security.service.IbookService;
@Service
public class BookService implements IbookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book book) {
		book.setCreateTime(LocalDate.now());
		return bookRepository.save(book);
	}
	
	@Override
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	@Override
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}
}
