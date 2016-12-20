package com.handbags.spring.DAO;

import java.util.List;

import com.handbags.spring.model.Brand;


public interface BrandDAO {
	
    public void  addBrandDAO(Brand brand);
	
	public List<Brand> getList();
	
	public Brand getBrandById(int brandId );
	
	public void deleteBrand(int brandId);
	
	public Brand getBrandByName(String brandName);
	

}
