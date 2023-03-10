package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
