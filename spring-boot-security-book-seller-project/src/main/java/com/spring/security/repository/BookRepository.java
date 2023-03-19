package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
