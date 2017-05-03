package com.niit.shoppingcart;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static SupplierDAO supplierDAO;
	@Autowired static Supplier supplier;
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
			
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
		
	}
	/*
	@Test
	public void createSupplierTestCase(){
		supplier.setId("supp01");
		supplier.setName("Zaveri 01");
		supplier.setAddress("Zaveri Bazar Mumbai");
		
		boolean flag = supplierDAO.save(supplier);
		assertEquals("create ", true, flag);
	}
*/
	@Test 
	public void updateSupplierTestCase(){
		supplier.setId("supp01");
		supplier.setName("Zaveri");
		supplier.setAddress("Mumbai 01");
		
		boolean flag = supplierDAO.update(supplier);
		assertEquals("üpdate supplier ", true, flag);
	}
	
	@Test
	public void getSupplierList(){
		int size = supplierDAO.list().size();
		assertEquals("get supplier ", 1, size);
	}

}

