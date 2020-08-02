package com.MyFirstSpringBootProj.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MyFirstSpringBootProj.sportyshoes.models.Users;
import com.MyFirstSpringBootProj.sportyshoes.repositories.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Transactional
	public Users addUsers(Users user) {

		return userRepo.save(user);

	}

	@Transactional
	public List<Users> getAllUsers() {
		return (List<Users>) userRepo.findAll();
	}

	@Transactional
	public Users getUserById(long l) {
		return userRepo.findById((long) l).orElse(null);
	}

	@Transactional
	public Users getUserByEmailId(String emailId) {
		return userRepo.findByEmailId(emailId);
	}

	@Transactional
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
	@Transactional
	public void deleteUserById(long Id) {
		 userRepo.deleteById(Id);
	}

}
