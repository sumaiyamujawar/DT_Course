package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {

	//Get all categories - List
	public List<Category> list();
	
	//Create Category - Save
	public boolean save(Category category);
	
	//Update Category - Update
	public boolean update(Category category);
	
	//Delete Category by ID
	public boolean delete(String id);
	
	//Get Category By ID - getCatByID
	public Category getCategoryByID(String id);
		
	//Get Category by Name
	public Category getCategoryByName(String name);
	
	
}
