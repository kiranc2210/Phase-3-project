package com.MyFirstSpringBootProj.sportyshoes.repositories;



import org.springframework.stereotype.Repository;


import com.MyFirstSpringBootProj.sportyshoes.models.PurchaseItem;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



 

@Repository
@Component
public interface PurchaseItemReporsitory extends JpaRepository<PurchaseItem, Long>{

	
	void deleteAllItemsByPurchaseId(long purchaseId);

	List<PurchaseItem> findAllByID(long purchaseId);


	

	
	
}
