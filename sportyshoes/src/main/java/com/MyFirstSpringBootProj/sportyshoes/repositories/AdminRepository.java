package com.MyFirstSpringBootProj.sportyshoes.repositories;

import org.springframework.stereotype.Repository;

import com.MyFirstSpringBootProj.sportyshoes.models.Admin;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Repository
@Component
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByAdminId(String adminId);



	
}
