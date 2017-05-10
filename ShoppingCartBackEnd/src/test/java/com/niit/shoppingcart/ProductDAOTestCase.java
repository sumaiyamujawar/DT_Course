package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductDAOTestCase {

	
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static ProductDAO productDAO;
	@Autowired static Product product;
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product= (Product)context.getBean("product");
		
	}
	
	@Test
	public void createProductTestCase(){
		product.setId("P06");
		product.setName("Niloufer Collection");
		product.setDescription("Niloufer Collection");
		product.setPrice(21000);
		product.setCategory_id("cat05");
		product.setSupplier_id("supp01");
		
		boolean flag = productDAO.save(product);
		
		assertEquals("create Product ", true, flag);
		
	} 
	/*
	@Test
	public void updateProductTestCase(){
		product.setId("P01");
		product.setName("Tiara Collection");
		product.setDescription("ZubinCollection");
		product.setPrice(120000);
		product.setCategory_id("cat01");
		product.setSupplier_id("supp01");
		boolean flag = productDAO.update(product);
		assertEquals("Product update", true, flag);
	}
	
	@Test
	public void listProductTestCase(){
		List<Product> productList = productDAO.list();
		assertEquals("Product List test case ", 3, productList.size());
	} */
	
	@Test
	public void getProductByIdTestCase(){
		Product p = productDAO.getProductById("P01");
		assertEquals("Get Product By id ", "Tiara Collection", p.getName());
	}
	
}
