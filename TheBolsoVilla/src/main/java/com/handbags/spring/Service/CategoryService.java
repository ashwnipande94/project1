package com.handbags.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.handbags.spring.Impl.CategoryImpl;
import com.handbags.spring.model.Category;


@Service
@Transactional
public class CategoryService {
	@Autowired
	CategoryImpl categoryImpl ;
	
	public void addCategory(Category category)
	{
		
		categoryImpl.addCategoryDAO(category);
		
	}
	
	public List<Category> getList(){
		
		return categoryImpl.getList();
	}
	public Category getCategoryById(int categoryId ){
		
		return categoryImpl.getCategoryById(categoryId);
	}

	public void deleteCategory(int categoryId) {
		categoryImpl.deleteCategory(categoryId);
	
	}
	
	public Category getCategoryByName(String categoryName){
		return categoryImpl.getCategoryByName(categoryName);
		}

	public String getJsonList() {
		return categoryImpl.getJsonList();
	}
}
