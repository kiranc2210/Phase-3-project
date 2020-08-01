package com.MyFirstSpringBootProj.sportyshoes.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MyFirstSpringBootProj.sportyshoes.models.PurchaseItem;
import com.MyFirstSpringBootProj.sportyshoes.repositories.PurchaseItemReporsitory;


@Component
public class PurchaseItemService {

	 @Autowired
	 private PurchaseItemReporsitory purchaseItemRepo;

	 @Transactional
		public PurchaseItem getItemById(long id) {
		 return purchaseItemRepo.findById(id).orElse(null);
		
		}
		
	 @Transactional
		public List<PurchaseItem> getAllItemsByPurchaseId(long purchaseId) {
		 return  purchaseItemRepo.findAllByID(purchaseId);
		}	
		
	 @Transactional
		public void updateItem(PurchaseItem item) {
		 PurchaseItem pItem = purchaseItemRepo.findById((long) item.getID()).orElse(null);
		 pItem.setPrice(item.getPrice());
		 pItem.setProductId(item.getProductId());
		 pItem.setPurchaseId(item.getPurchaseId());
		 pItem.setQty(item.getQty());
		 pItem.setRate(item.getRate());
		 pItem.setUserId(item.getUserId());
		 purchaseItemRepo.save(pItem);
		}
		

	 @Transactional
		public void deleteItem(long id) {
		 purchaseItemRepo.deleteById(id);
		}

	 @Transactional
		public void deleteAllItemsForPurchaseId(long purchaseId) {
		 purchaseItemRepo.deleteAllItemsByPurchaseId(purchaseId);
		}


	 
}
