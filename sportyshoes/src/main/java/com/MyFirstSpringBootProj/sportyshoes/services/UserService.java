package com.MyFirstSpringBootProj.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MyFirstSpringBootProj.sportyshoes.models.Users;
import com.MyFirstSpringBootProj.sportyshoes.repositories.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepo;


	public Users addUsers(Users user) {
	
		return 	userRepo.save(user);
		
	}
	
	
		public Users getUserById(long l) {
		 	return userRepo.findById((long) l).orElse(null);
		}
	 

	public Users getUserByEmailId(String emailId) {
		return userRepo.findByEmailId(emailId);
	}

	public void updateUser(Users user) {
		Users existingUser = userRepo.findById((long) user.getID()).orElse(null);
		existingUser.setFname(user.getFname());
		existingUser.setLname(user.getLname());
		existingUser.setAge(user.getAge());
		existingUser.setAddress(user.getAddress());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setPwd(user.getPwd());
		existingUser.setDateAdded(user.getDateAdded());
		userRepo.save(existingUser);
	}

		public List<Users> getAllUsers() {
		 return userRepo.findAll();
		}	 
}
