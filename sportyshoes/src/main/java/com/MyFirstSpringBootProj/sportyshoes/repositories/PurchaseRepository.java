package com.MyFirstSpringBootProj.sportyshoes.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Component;


import com.MyFirstSpringBootProj.sportyshoes.models.Purchase;



@Repository
@Component
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	List<Purchase> getAllItemsByUserId(long userId);

	
	

	
}
