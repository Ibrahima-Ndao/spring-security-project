package com.spring.security.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.model.PurchaseHistry;
import com.spring.security.repository.PurchaseRepository;
import com.spring.security.repository.projection.PurchaseHIstoryItem;
import com.spring.security.service.IpurchaseHistoryService;
@Service
public class PurchaseService implements IpurchaseHistoryService {
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Override
	public PurchaseHistry save(PurchaseHistry purchaseHistry) {
		purchaseHistry.setPurchaseTime(LocalDate.now());
		return purchaseRepository.save(purchaseHistry);
	}
	
	@Override
	public List<PurchaseHIstoryItem> findPurchaseOfUser(Long userId){
		return purchaseRepository.findAllPurchaseOfUser(userId);
	}
}
