package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Entity //To map the database table
@Table(name="User")//if the table name and domain class name is different
@Component //context.scan("com.niit") --will scan the pacakge and create singlton instances
public class User {
		
	//Define all the properties for all the fields in the table
	
	//Mention primay key
	@Id
	private String id;
	
	@Column(name="name") //If the field name in the table and property name in class is different
						// need to specify column name else not required to specify
	private String name; 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	} 
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	//@Min(2)
	//@Max(15)
	private String password; 
	private String contact;
	private String role;
	
}
