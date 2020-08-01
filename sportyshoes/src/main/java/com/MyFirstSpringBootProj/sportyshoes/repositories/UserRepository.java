package com.MyFirstSpringBootProj.sportyshoes.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;

import com.MyFirstSpringBootProj.sportyshoes.models.Users;

@Repository
@Component
public interface UserRepository extends CrudRepository<Users, Long> {

	Users findByEmailId(String emailId);

	

}
