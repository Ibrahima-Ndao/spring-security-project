package com.spring.security.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "purchase_histry")
public class PurchaseHistry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "purchaseTime", nullable = false)
	private LocalDate purchaseTime;
	
	@Column(name = "user_Id", nullable = false)
	private Long userId;
	
	@Column(name = "book_Id", nullable = false)
	private Long bookId;

	public PurchaseHistry() {
	}

	public PurchaseHistry(Long id, Double price, LocalDate purchaseTime, Long userId, Long bookId) {
		this.id = id;
		this.price = price;
		this.purchaseTime = purchaseTime;
		this.userId = userId;
		this.bookId = bookId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(LocalDate purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	
}
