package com.MyFirstSpringBootProj.sportyshoes.repositories;

import org.springframework.stereotype.Repository;

import com.MyFirstSpringBootProj.sportyshoes.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Repository
@Component
public interface ProductRepository extends JpaRepository<Product, Long> {

	

}
