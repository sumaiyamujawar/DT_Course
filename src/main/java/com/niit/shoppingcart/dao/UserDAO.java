package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO {

	//Declare the methods
	
	//What type of Operations we are going to do for User
	
	//Operations
	//1) Create/Register User - save
	//2) Update the User details - update
	//3) Validate the credentials - validate
	//4) Get all Users - list 
	//5) Get User By User id - get
	
	//Declare the method with the proper signature
	//access_specifier return_type methodName(parameter_list) throws exceptionlist
	
	//Create/Register User - save
	public boolean save(User user);
	
	//Update the User details - update
	public boolean update(User user);
	
	//Validate the credentials - validate
	//we are going to use Spring security in future
	//we can delete this method after using spring security
	public boolean validate(String id, String password);
	
	//get all user lists
	public List<User> list();
	
	//get user details by id	
	public User get(String id);
}
