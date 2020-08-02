package com.MyFirstSpringBootProj.sportyshoes.repositories;

import org.springframework.stereotype.Repository;

import com.MyFirstSpringBootProj.sportyshoes.models.Admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Repository
@Component
public interface AdminRepository extends CrudRepository<Admin, Long> {

	Admin findByAdminId(String adminId);

}
