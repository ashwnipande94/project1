package com.handbags.spring.Impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import com.handbags.spring.DAO.SubcategoryDAO;
import com.handbags.spring.model.Subcategory;

@Repository
public class SubcategoryImpl implements SubcategoryDAO{
	@Autowired
	SessionFactory sessionFactory;

	public SubcategoryImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	}

	public void addSubcategoryDAO(Subcategory subcategory){
		sessionFactory.getCurrentSession().saveOrUpdate(subcategory);
		
	}
	
	public List<Subcategory> getList() {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Subcategory";
		@SuppressWarnings("unchecked")
		List<Subcategory> clist=session.createQuery(hql).getResultList();
		return clist;
		}

		public Subcategory getSubcategoryById(int subcategoryId ) {
			Session session =sessionFactory.getCurrentSession();
			String hql="from Subcategory where subcategoryId =" +subcategoryId;
			@SuppressWarnings("unchecked")
			List<Subcategory> clist=session.createQuery(hql).getResultList();
			return clist.get(0);
		} 

		public void deleteSubcategory(int subcategoryId){
			Subcategory subcategoryToDelete= new Subcategory();	
			subcategoryToDelete.setSubcategoryId(subcategoryId);
		sessionFactory.getCurrentSession().delete(subcategoryToDelete);
			
		}
		public Subcategory getSubcategoryByName(String subcategoryName) {
			Session session =sessionFactory.getCurrentSession();
			String hql="from Subcategory where subcategoryName="+"'"+subcategoryName+"'";
			@SuppressWarnings("unchecked")
			List<Subcategory> clist=session.createQuery(hql).getResultList();
			return clist.get(0);
		
		
		}
		
		
		public String getJsonList(){
			
			Session session =sessionFactory.getCurrentSession();
			String hql="from Subcategory";
			@SuppressWarnings("unchecked")
			List<Subcategory> clist=session.createQuery(hql).getResultList();
			
			Gson gson = new Gson();
	        String jsonList = gson.toJson(clist);
			return jsonList;	
			
		}
		}


