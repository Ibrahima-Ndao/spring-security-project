package com.kangam.cimeterymanagementsystem.repository;

import com.kangam.cimeterymanagementsystem.model.PersonDie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDieRepository extends JpaRepository<PersonDie, Long> {
}
