package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired 
	private SessionFactory sessionFactory;
	
	public void supplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().save(supplier);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().update(supplier);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	
	}

	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery(" from Supplier").list();
	}
	
	
	
	

}
