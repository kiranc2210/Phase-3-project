package com.MyFirstSpringBootProj.sportyshoes.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.MyFirstSpringBootProj.sportyshoes.models.Category;

import com.MyFirstSpringBootProj.sportyshoes.repositories.CategoryRepository;


@Component
public class CategoryService {

	 @Autowired
	 private CategoryRepository categoryRepo;

	 @Transactional
		public Category getCategoryById(long id) {
		 	return categoryRepo.findById(id).orElse(null);
		}
		
		
	 @Transactional
	 public void updateCategory(Category category) {
		 Category existingcategory = categoryRepo.findById((long) category.getID()).orElse(null);
		 existingcategory.setName(category.getName());
		 categoryRepo.save(category);
		}
		

	 @Transactional
	 public void deleteCategory(long id) {
		 categoryRepo.deleteById(id);
		}

	 @Transactional
	 public List<Category> getAllCategories() {
		 return categoryRepo.findAll();
		}
		
//	 private Sort sortByIdAsc() {
//	        return new Sort(Sort.Direction.ASC, "id");
//	    }
	 @Transactional
	 public String getCategoriesDropDown(long id) {
		 StringBuilder sb = new StringBuilder("");
		 List<Category> list = categoryRepo.findAll();
		 for(Category cat: list) {
			 if (cat.getID() == id)
				 sb.append("<option value=" + String.valueOf(cat.getID()) + " selected>" + cat.getName() + "</option>");
			 else
				 sb.append("<option value=" + String.valueOf(cat.getID()) + ">" + cat.getName() + "</option>");
				 
		 }
		 return sb.toString();
		}
		

		 
}
