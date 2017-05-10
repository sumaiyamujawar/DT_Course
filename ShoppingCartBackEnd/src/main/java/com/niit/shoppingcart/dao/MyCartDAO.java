package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.MyCart;

public interface MyCartDAO {

	public boolean save(MyCart myCart);
	public boolean update(MyCart myCart);
	public List<MyCart> list();
	public MyCart getMyCartById(String id);
	
	public double getTotalAmount(String userID);
	
	//No. of product also should display in UI
	//this we can get from list()
}
