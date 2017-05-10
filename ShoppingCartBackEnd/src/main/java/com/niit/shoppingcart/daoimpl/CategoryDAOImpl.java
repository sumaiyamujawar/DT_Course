package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Repository("categoryDAO") 
// it means CategoryDAOImpl categoryDAO = new categoryDAOImpl()
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//Get all Categories
	public List<Category> list() {
		return getCurrentSession().createQuery(" from Category").list();
	}
	
	//Create category
	public boolean save(Category category) {
		try{
			getCurrentSession().save(category);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//Update Category by Id
	public boolean update(Category category) {
		try{
			getCurrentSession().update(category);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//Delete Category by Id
	public boolean delete(String id) {
		try{
			getCurrentSession().delete(getCategoryByID(id));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//Get Category by Id
	public Category getCategoryByID(String id) {
		//get method if parameter is Primary key
		return (Category)getCurrentSession().get(Category.class, id);
	}

	//Get Category by name
	public Category getCategoryByName(String name) {
		Query query = getCurrentSession().createQuery(" from Category where name = ?");
		query.setString(0, name);
		return (Category)query.uniqueResult();
	}


}
