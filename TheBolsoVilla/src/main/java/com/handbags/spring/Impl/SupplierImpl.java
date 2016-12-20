package com.handbags.spring.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.handbags.spring.DAO.SupplierDAO;
import com.handbags.spring.model.Supplier;
@Repository
public class SupplierImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;

	public SupplierImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	}

	public void addSupplierDAO(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		
	}

	public List<Supplier> getList() {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Supplier";
		@SuppressWarnings("unchecked")
		List<Supplier> clist=session.createQuery(hql).getResultList();
		return clist;
		
		
	}

	public Supplier getSupplierById(int SupplierId) {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Supplier where SupplierId =" +SupplierId;
		@SuppressWarnings("unchecked")
		List<Supplier> clist=session.createQuery(hql).getResultList();
		return clist.get(0);
	} 
	

	public void deleteSupplier(int SupplierId) {
		Supplier supplierToDelete= new Supplier();	
		supplierToDelete.setSupplierId(SupplierId);
		sessionFactory.getCurrentSession().delete(supplierToDelete);
		
		
	}

	public Supplier getSupplierByName(String supplierName) {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Supplier where SupplierName="+"'"+supplierName+"'";
		@SuppressWarnings("unchecked")
		List<Supplier> clist=session.createQuery(hql).getResultList();
		return clist.get(0);
	
	
	}

	public String getJsonList() {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Supplier";
		@SuppressWarnings("unchecked")
		List<Supplier> clist=session.createQuery(hql).getResultList();
		
		Gson gson = new Gson();
        String jsonList = gson.toJson(clist);
		return jsonList;
		
	}

	
}