package com.MyFirstSpringBootProj.sportyshoes.services;
import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MyFirstSpringBootProj.sportyshoes.models.Purchase;
import com.MyFirstSpringBootProj.sportyshoes.repositories.PurchaseRepository;
 


@Component
public class PurchaseService {

	 @Autowired
	 private PurchaseRepository purchaseRepo;

		@Transactional
		public Purchase getPurchaseById(long id) {
			return purchaseRepo.findById(id).orElse(null);
		}
		
		@Transactional
		public List<Purchase> getAllItems() {
			return purchaseRepo.findAll();
		}			
		
		@Transactional
		public List<Purchase> getAllItemsByUserId(long userId) {
			return purchaseRepo.getAllItemsByUserId(userId);
		}	
		
		@Transactional
		public Purchase  updatePurchase(Purchase purchase) {
			Purchase purchas= purchaseRepo.findById((long) purchase.getID()).orElse(null);
			if(purchas!=null) {
			purchas.setUserId(purchase.getUserId());
			purchas.setTotal(purchase.getTotal());
			purchas.setDate(Calendar.getInstance().getTime());
			return purchaseRepo.save(purchas);
			}else {
				return purchaseRepo.save(purchase);
			}
		}
		

		@Transactional
		public void deletePurchase(long id) {
			purchaseRepo.deleteById(id);
		}

	 
}
