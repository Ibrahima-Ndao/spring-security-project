package com.spring.security.service;

import java.util.List;

import com.spring.security.model.PurchaseHistry;
import com.spring.security.repository.projection.PurchaseHIstoryItem;

public interface IpurchaseHistoryService {

	PurchaseHistry save(PurchaseHistry purchaseHistry);

	List<PurchaseHIstoryItem> findPurchaseOfUser(Long userId);

}
