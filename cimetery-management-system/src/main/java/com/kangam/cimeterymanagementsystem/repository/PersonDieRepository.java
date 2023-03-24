package com.kangam.cimeterymanagementsystem.repository;

import com.kangam.cimeterymanagementsystem.model.PersonDie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDieRepository extends JpaRepository<PersonDie, Long> {
    List<PersonDie> findByCodeRef(String code_ref);
}
