package com.handbags.spring.DAO;

import java.util.List;
import com.handbags.spring.model.Supplier;



public interface SupplierDAO {

	public void  addSupplierDAO(Supplier supplier);
	
	public List<Supplier> getList();
	
	public Supplier getSupplierById(int SupplierId );
	
	public void deleteSupplier(int SupplierId);
	
	public Supplier getSupplierByName(String SupplierName);
}
