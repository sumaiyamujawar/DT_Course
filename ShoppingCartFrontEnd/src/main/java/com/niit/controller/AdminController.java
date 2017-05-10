package com.niit.controller;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	//SL4J - Simple Logging Facade for Java
	
	//private static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	
	
	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories(){
	
		//log.debug("Starting of the method manageCategories");
		ModelAndView mv=new ModelAndView("Home");
		mv.addObject("isAdminClickedCategories","true");
		mv.addObject("isAdmin","true");
		//log.debug("Ending of the method manageCategories");
		return mv;
	}
	
	@RequestMapping("/manageSuppliers")
	public ModelAndView manageSuppliers(){
		//log.debug("Starting of the method manageSuppliers");
		ModelAndView mv=new ModelAndView("Home");
		mv.addObject("isAdminClicked Supplier","true");
		mv.addObject("isAdmin","true");
		//log.debug("Ending of the method manageSuppliers");
		return mv;
	}
	
	@RequestMapping("/manageProducts")
	public ModelAndView manageProducts(){
	//	log.debug("Starting of the method manageProducts");
		ModelAndView mv=new ModelAndView("Home");
		mv.addObject("isAdminClickedProduct","true");
		mv.addObject("isAdmin","true");
		//log.debug("Ending of the method manageProducts");
		return mv;
	}
}
