package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.User;

public class CategoryDAOTestCase {

	//To use annotations like @Repository, @Component, @Configuration
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static CategoryDAO categoryDAO;
	@Autowired static Category category;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		//Scan the complete package and checks the annotations.
		context.scan("com.niit");
		//remove other instances	
		context.refresh();
		
		//get the userDAO from context
		categoryDAO =  (CategoryDAO) context.getBean("categoryDAO");
		
		//get the user from context
		
		category = (Category)context.getBean("category");
				
	} 
	/*
	@Test
	public void createCategoryTestCase()
	{
		category.setId("catTest");
		category.setName("Bracelets");
		category.setDescription("Gold Bracelets");
		boolean flag =  categoryDAO.save(category);
	
		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("create Category TestCase ",true,flag);
		
	}
	
	*/
	/*
	@Test
	public void updateCategoryTestCase(){
		category.setId("cat01");
		category.setName("NeckLace");
		category.setDescription("Delicate Gold Necklace");
		boolean flag = categoryDAO.update(category);
	
		assertEquals("update Category testcasse ", true, flag);
	}
	*/
	@Test
	public void getAllCategoriesTestCase(){
		List<Category> categories = categoryDAO.list();
		assertEquals("Category List ", 5, categories.size());
	} 
	
	/*
	@Test
	public void deleteCategoryTestCase(){
		boolean flag = categoryDAO.delete("catTest");
		
		assertEquals("Delete Category ", true, true);
	} */
	
	@Test
	public void getCategoryByIdTestCase(){
		Category c = categoryDAO.getCategoryByID("cat01");
		assertEquals("Get Category By id ", "NeckLace", c.getName());
	}
	
	
}
