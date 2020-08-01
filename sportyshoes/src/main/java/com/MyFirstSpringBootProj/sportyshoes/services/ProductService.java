package com.MyFirstSpringBootProj.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MyFirstSpringBootProj.sportyshoes.models.Product;

import com.MyFirstSpringBootProj.sportyshoes.repositories.ProductRepository;


@Component
public class ProductService {

	 @Autowired
	 private ProductRepository productRepo;


		@Transactional
		public Product getProductById(long id) {
			return productRepo.findById(id).orElse(null);
		}
		
		
		@Transactional
		public void updateProduct(Product product) {
			Product existingProduct = productRepo.findById((long) product.getID()).orElse(null);
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setDateAdded(product.getDateAdded());
			productRepo.save(existingProduct);
		}
		

		@Transactional
		public void deleteProduct(long id) {
			
			productRepo.deleteById(id);
		}

		@Transactional
		@Query("FROM City ORDER BY name ASC")
		public List<Product> getAllProducts() {
			return productRepo.findAll();
		}
	 
//		@Transactional
//		public List<Object> getAllProductsWithJoin() {
//			return productRepo.getAllProductsWithJoin();
//		}
//	 		
}
