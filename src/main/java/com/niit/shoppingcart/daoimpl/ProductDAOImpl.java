package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean save(Product product) {
		try{
			sessionFactory.getCurrentSession().save(product);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<Product> list() {
		return getCurrentSession().createQuery(" from Product").list();
	}
	public Product getProductById(String id) {
		return (Product)getCurrentSession().get(Product.class, id);
	}

	public List<Product> getAllProductsByCategoryID(String categoryId) {
		// TODO Auto-generated method stub
		
		Query query = getCurrentSession().createQuery("from Product where categoryID = ?");
	    return (List<Product>) query.setString(0, categoryId);
		
	
	}

	
	
}
