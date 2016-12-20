package com.handbags.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.handbags.spring.Impl.SupplierImpl;
import com.handbags.spring.model.Supplier;

@Service
@Transactional
public class SupplierService {
	@Autowired
	SupplierImpl supplierImpl ;
	
	public void addSupplierDAO(Supplier supplier)
	{
		
		supplierImpl.addSupplierDAO(supplier);
		
	}
	
	public List<Supplier> getList(){
		
		return supplierImpl.getList();
	}
	public Supplier getSupplierById(int SupplierId ){
		
		return supplierImpl.getSupplierById(SupplierId);
	}

	public void deleteSupplier(int SupplierId) {
		supplierImpl.deleteSupplier(SupplierId);
}
	
	public Supplier getSupplierByName(String SupplierName){
		return supplierImpl.getSupplierByName(SupplierName);
		}

	public String getJsonList() {
	return supplierImpl.getJsonList();
	}

	
}