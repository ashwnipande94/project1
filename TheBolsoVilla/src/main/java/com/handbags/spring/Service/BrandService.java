package com.handbags.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.handbags.spring.Impl.BrandImpl;
import com.handbags.spring.model.Brand;


@Service
@Transactional
public class BrandService {

	@Autowired
	BrandImpl brandImpl ;
	
	public void addBrand(Brand brand)
	{
		
		brandImpl.addBrandDAO(brand);
		
	}
	
	public List<Brand> getList(){
		
		return brandImpl.getList();
	}
	public Brand getBrandById(int brandId ){
		
		return brandImpl.getBrandById(brandId);
	}

	public void deleteBrand(int brandId) {
		brandImpl.deleteBrand(brandId);
	
	}
	
	public Brand getBrandByName(String brandName){
		return brandImpl.getBrandByName(brandName);
		}

	public  String getJsonList() {
		return brandImpl.getJsonList();
	}


}
