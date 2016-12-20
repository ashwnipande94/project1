package com.handbags.spring.DAO;

import java.util.List;
import com.handbags.spring.model.Subcategory;

public interface SubcategoryDAO {

	public void  addSubcategoryDAO(Subcategory subcategory);
	
	public List<Subcategory> getList();
	
	public Subcategory getSubcategoryById(int subcategoryId );
	
	public void deleteSubcategory(int subcategoryId);

	public Subcategory getSubcategoryByName(String subcategoryName);
}

