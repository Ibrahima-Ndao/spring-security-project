package com.spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.security.model.PurchaseHistry;
import com.spring.security.repository.projection.PurchaseHIstoryItem;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseHistry, Long> {
	@Query("select b.title as title, ph.price as price, ph.purchaseTime as purchaseTime from PurchaseHistry ph left join Book b on ph.id = b.id where ph.userId = :userId")
	List<PurchaseHIstoryItem> findAllPurchaseOfUser(@Param("userId") Long userId);
}
