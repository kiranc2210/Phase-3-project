package com.MyFirstSpringBootProj.sportyshoes.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.MyFirstSpringBootProj.sportyshoes.models.Category;

@Repository
@Component
public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}
