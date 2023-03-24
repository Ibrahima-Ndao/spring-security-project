package com.kangam.cimeterymanagementsystem.repository;

import com.kangam.cimeterymanagementsystem.model.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
}
