package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.domain.MyCart;

@Repository("myCartDAO")
@Transactional
public class MyCartDAOImpl implements MyCartDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public MyCartDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean save(MyCart myCart) {
		try{
			sessionFactory.getCurrentSession().save(myCart);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean update(MyCart myCart) {
		try{
			sessionFactory.getCurrentSession().update(myCart);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<MyCart> list() {
		return getCurrentSession().createQuery(" from MyCart").list();
	}
	public MyCart getMyCartById(String id) {
		return (MyCart)getCurrentSession().get(MyCart.class, id);
	}

	public double getTotalAmount(String userID) {
		// TODO Auto-generated method stub
		Query query =  getCurrentSession().createQuery("SELECT sum(price) from MyCart where user_id = ?");
		query.setString(0, userID);		
		return (Double) query.uniqueResult();
	}

	
	
}
