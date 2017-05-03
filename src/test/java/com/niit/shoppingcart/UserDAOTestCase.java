package com.niit.shoppingcart;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {

	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static UserDAO  userDAO;
	
	@Autowired  static User user;
	
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		userDAO =  (UserDAO) context.getBean("userDAO");
		
		//get the user from context
		
		user = (User)context.getBean("user");
				
	}
	/*
	@Test
	public void createUserTestCase()
	{
		user.setId("sajid");
		user.setName("Sajid Mujawar");
		user.setPassword("sajid");
		user.setRole("ROLE_USER");
		user.setContact("900378660");
		boolean flag =  userDAO.save(user);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createUser TestCase  abcd",true,flag);
		
	}
	
	
	@Test
	public void updateUserTestCase()
	{
		user.setId("sumaiya");
		user.setName("Sumaiya Mujawar");
		user.setPassword("sumaiya");
		user.setRole("ROLE_USER");
		user.setContact("900786000");
		boolean flag =  userDAO.update(user);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals(" update user test case",true,flag);
		
	}
	
	
	@Test
	public void validateUSerTestCase()
	{
		
		boolean flag =  userDAO.validate("sumaiya", "sumaiya");
		
		
		assertEquals(true, flag);
		
	}
	
	@Test
	public void getAllUserTestCase()
	{
		int actualSize=   userDAO.list().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(2, actualSize);
	}
	*/
	@Test
	public void getUserById(){
		User user = userDAO.get("sajid");
		String password = user.getId();
		assertEquals("sajid", password);
	}
	
}

