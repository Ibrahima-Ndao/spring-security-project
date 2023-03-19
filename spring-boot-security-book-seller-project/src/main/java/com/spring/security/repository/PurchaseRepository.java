package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.PurchaseHistry;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseHistry, Long> {

}
