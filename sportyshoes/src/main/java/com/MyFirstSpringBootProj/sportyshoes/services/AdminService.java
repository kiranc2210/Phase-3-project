package com.MyFirstSpringBootProj.sportyshoes.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MyFirstSpringBootProj.sportyshoes.models.Admin;

import com.MyFirstSpringBootProj.sportyshoes.repositories.AdminRepository;

@Component
public class AdminService {

	 @Autowired
	 private AdminRepository adminRepo;

		
		private Admin  getAdminByAdminId(String adminId) {
			Admin admin=adminRepo.findByAdminId(adminId);
			return admin;
		}
			
		
		@Transactional
		public Admin getAdminById(long id) {
			return adminRepo.findById(id).orElse(null);
		}		
		
		@Transactional
		public void updatePwd(Admin admin) {
			Admin existingAdmin = adminRepo.findById((long) admin.getID()).orElse(null);
			existingAdmin.setAdminPwd(admin.getAdminPwd());
			adminRepo.save(admin);
		}
		@Transactional
		public Admin authenticate(String adminId, String pwd) {
			Admin admin=getAdminByAdminId(adminId);
			if(!(adminId==null) && !(pwd==null) && adminId.equals(admin.getAdminId()) && pwd.equals(admin.getAdminPwd())) {
				return admin;
			}
			return null;
			

		}




		 
}
