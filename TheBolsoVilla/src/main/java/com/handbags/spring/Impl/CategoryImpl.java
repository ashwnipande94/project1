package com.handbags.spring.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.handbags.spring.DAO.CategoryDAO;
import com.handbags.spring.model.Category;
@Repository
public class CategoryImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public CategoryImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
	}

	public String getJsonList() {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Category";
		@SuppressWarnings("unchecked")
		List<Category> clist=session.createQuery(hql).getResultList();
		
		Gson gson = new Gson();
        String jsonList = gson.toJson(clist);
		return jsonList;
		}
	
	public void addCategoryDAO(Category category) {

	sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	public List<Category> getList() {
	Session session =sessionFactory.getCurrentSession();
	String hql="from Category";
	@SuppressWarnings("unchecked")
	List<Category> clist=session.createQuery(hql).getResultList();
	return clist;
	}

	public Category getCategoryById(int categoryId ) {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Category where categoryId =" +categoryId;
		@SuppressWarnings("unchecked")
		List<Category> clist=session.createQuery(hql).getResultList();
		return clist.get(0);
	} 

	public void deleteCategory(int categoryId){
	Category categoryToDelete= new Category();	
	categoryToDelete.setCategoryId(categoryId);
	sessionFactory.getCurrentSession().delete(categoryToDelete);
		
	}
	public Category getCategoryByName(String categoryName){
		Session session =sessionFactory.getCurrentSession();
		String hql="from Category where categoryName="+"'"+categoryName+"'";
		@SuppressWarnings("unchecked")
		List<Category> clist=session.createQuery(hql).getResultList();
		return clist.get(0);
	
	
	}

}