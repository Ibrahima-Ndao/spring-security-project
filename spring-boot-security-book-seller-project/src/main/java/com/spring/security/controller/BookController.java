package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Book;
import com.spring.security.service.IbookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	private IbookService bookService;
	
	@PostMapping
	public ResponseEntity<Book> saveBooks(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(bookService.findAllBooks(), HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello world i'am fron Senegal";
	}
}
