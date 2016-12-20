package com.handbags.spring.DAO;

import java.util.List;

import com.handbags.spring.model.Product;


public interface ProductDAO {

    public void  addProductDAO(Product product);
	
	public List<Product> getList();
	
	public Product getProductById(int productId );
	
	public void deleteProduct(int productId);
	
}

