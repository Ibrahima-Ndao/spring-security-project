package com.spring.security.repository.projection;

import java.time.LocalDateTime;

public interface PurchaseHIstoryItem {
	String getTitle();
	Double getPrice();
	LocalDateTime getPurchaseTime();
}
