package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();		
		
		context.scan("com.niit"); //Scan this package and find out where are the Annotations. //@Component
		
		context.refresh();
		
		//if you need any instance, do not create
		//you can ask context to get a particular bean getBean()
		
		context.getBean("category"); //The bean name same as class name but first character
										//will be lower case
	
		System.out.println("The user instance is created successfully!!");
	}
	
}
