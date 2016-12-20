package com.handbags.spring.DAO;

import java.util.List;

import com.handbags.spring.model.Category;



public interface CategoryDAO {

	public void  addCategoryDAO(Category category);
	
	public List<Category> getList();
	
	public Category getCategoryById(int categoryId );
	
	public void deleteCategory(int categoryId);
	
	public Category getCategoryByName(String categoryName);
}
 