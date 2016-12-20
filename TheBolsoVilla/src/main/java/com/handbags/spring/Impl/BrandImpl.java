package com.handbags.spring.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import com.handbags.spring.DAO.BrandDAO;
import com.handbags.spring.model.Brand;


@Repository
public class BrandImpl implements BrandDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public BrandImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	}

	public void addBrandDAO(Brand brand) {

	sessionFactory.getCurrentSession().saveOrUpdate(brand);
	}

	public List<Brand> getList() {
	Session session =sessionFactory.getCurrentSession();
	String hql="from Brand";
	@SuppressWarnings("unchecked")
	List<Brand> clist=session.createQuery(hql).getResultList();
	return clist;
	}

	public Brand getBrandById(int brandId ) {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Brand where brandId =" +brandId;
		@SuppressWarnings("unchecked")
		List<Brand> clist=session.createQuery(hql).getResultList();
		return clist.get(0);
	} 

	public void deleteBrand(int brandId){
		Brand brandToDelete= new Brand();	
		brandToDelete.setBrandId(brandId);
	sessionFactory.getCurrentSession().delete(brandToDelete);
		
	}
	
	
	public Brand getBrandByName(String brandName){
		Session session =sessionFactory.getCurrentSession();
		String hql="from Brand where brandName="+"'"+brandName+"'";
		@SuppressWarnings("unchecked")
		List<Brand> clist=session.createQuery(hql).getResultList();
		return clist.get(0);
	
	
	}

	public String getJsonList() {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Brand";
		@SuppressWarnings("unchecked")
		List<Brand> clist=session.createQuery(hql).getResultList();
		
		Gson gson = new Gson();
        String jsonList = gson.toJson(clist);
		return jsonList;
		}

	
	}



