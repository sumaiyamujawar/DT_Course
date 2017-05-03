package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.domain.MyCart;

public class MyCartDAOTestCase {

	
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static MyCartDAO myCartDAO;
	@Autowired static MyCart myCart;
	
	Date date_added= new Date();
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		myCartDAO = (MyCartDAO) context.getBean("myCartDAO");
		myCart= (MyCart)context.getBean("myCart");
		
	}
	/*
	@Test
	public void createMyCartTestCase(){
		
		myCart.setId("Cart02");
		myCart.setProduct_name("Necklace");
		myCart.setUser_id("sumaiya");
		myCart.setQuantity(01);
		myCart.setStatus("Y");
		myCart.setDate_added(date_added);
		myCart.setPrice(15000);
		
		
		boolean flag = myCartDAO.save(myCart);
		
		assertEquals("create MyCart ", true, flag);
		
	} 
	
	@Test
	public void updateMyCartTestCase(){
		myCart.setId("Cart01");
		myCart.setProduct_name("Earing");
		myCart.setUser_id("sajid");
		myCart.setQuantity(01);
		myCart.setStatus("Y");
		myCart.setDate_added(date_added);
		myCart.setPrice(15000);
		boolean flag = myCartDAO.update(myCart);
		assertEquals("MyCart update", true, flag);
	}
	
	@Test
	public void listMyCartTestCase(){
		List<MyCart> myCartList = myCartDAO.list();
		assertEquals("MyCart List test case ", 3, myCartList.size());
	} 
	*/
	
	@Test
	public void getMyCartByIdTestCase(){
		MyCart p = myCartDAO.getMyCartById("Cart02");
		assertEquals("Get MyCart By id ", "Necklace", p.getProduct_name());
	} 
	
}
