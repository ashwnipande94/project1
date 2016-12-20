package com.handbags.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.handbags.spring.Impl.SubcategoryImpl;
import com.handbags.spring.model.Subcategory;

@Service
@Transactional
public class SubcategoryService {
	@Autowired
	SubcategoryImpl subcategoryImpl ;
	
	public void addSubcategoryDAO(Subcategory subcategory)
	{
		subcategoryImpl.addSubcategoryDAO(subcategory);
		
	}
	
	public List<Subcategory> getList(){
		
		return subcategoryImpl.getList();
	}
	public Subcategory getSubcategoryById(int subcategoryId ){
		
		return subcategoryImpl.getSubcategoryById(subcategoryId);
	}

	public void deleteSubcategory(int subcategoryId) {
		subcategoryImpl.deleteSubcategory(subcategoryId);
	
	}

	public Subcategory getSubcategoryByName(String subcategoryName){
		return subcategoryImpl.getSubcategoryByName(subcategoryName);
		}
	
	public String getJsonList(){
		
	return subcategoryImpl.getJsonList();	
	}
	
}
