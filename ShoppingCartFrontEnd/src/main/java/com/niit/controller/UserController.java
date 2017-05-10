package com.niit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {
	
	private static Logger log=LoggerFactory.getLogger(UserController.class);

	@Autowired UserDAO userDAO;
	@Autowired User user;
	
	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("userName") String id, 
			@RequestParam("password") String password){
		
		log.debug("Starting of the method login");
		log.info("You are loging with id " + id);
		ModelAndView mv = new ModelAndView("/Home");
		if(userDAO.validate(id, password)== true){
			log.debug("Valid credentials ");
			user = userDAO.get(id);
		    mv.addObject("message", "Welcome : " + user.getName());
		    
		    //check whether user is admin or customer
		    
		    if(user.getRole().equals("admin")){
		    	log.debug("You are admin");
		    	mv.addObject("isAdmin","true");
		    }else {
		    	log.debug("You are customer");
		    	mv.addObject("isAdmin", "false");
		    }
		}else{
			log.debug("Ïnvalid User");
			mv.addObject("message", "Invalid credential..Please Try again");
		}
		return mv;
	}
}
