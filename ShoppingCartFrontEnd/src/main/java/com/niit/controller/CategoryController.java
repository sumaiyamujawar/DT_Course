package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Controller
public class CategoryController {
	
	
	@Autowired CategoryDAO categoryDAO;
	@Autowired Category category;
	
	@Autowired ProductDAO productDAO;
	@Autowired Product product;
	
	@Autowired HttpSession session;
	
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping("/manage_category_add")
	//@GetMapping("/manage_category_add")
	public ModelAndView createCategory(@RequestParam("id") String id,@RequestParam("name") String name,
			@RequestParam("description") String description){
	
		    //log.debug("Starting of the method createCategory");
			category.setId(id);
			category.setName(name);
			category.setDescription(description);			
			
		//	ModelAndView mv = new ModelAndView("Home");
			ModelAndView mv = new ModelAndView("redirect:/manageCategories");
			mv.addObject("isAdminClickedCategories","true");
			mv.addObject("isAdmin","true");
			
			//Before calling save check if exists
			if(categoryDAO.getCategoryByID(id) !=null){
				mv.addObject("message","Catgory already exist" + id);
				return mv;
			} else {
				categoryDAO.save(category);
				mv.addObject("message","Category saved succssfully");
			}
			
			//to get updated data after adding/deleting
			session.setAttribute("categoryList", categoryDAO.list());
			session.setAttribute("category", category);
			//  log.debug("Ending of the method createCategory");
		return mv;
	}
	

	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id){
		
		log.debug("Starting of the method deleteCategory");
		log.debug("You are going to delete " + id);
		//ModelAndView mv=new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
	
		//check whether products are there for this category or not
		int size=productDAO.getAllProductsByCategoryID(id).size();
		if( size != 0){
			log.debug("Few products are there under this category");
			mv.addObject("message", size + " Few products are there under this category " + id);
			session.setAttribute("message", size + " Few products are there under this category " + id);
			return mv;
		}
		
		if(categoryDAO.delete(id)){
			mv.addObject("message","Successfully delete the category " + id);
		} 
		else {
			mv.addObject("message", "Couldn't delete the error");
		}
		
		//To get the current data
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);
		 // log.debug("Ending of the method deleteCategory");
		return mv;
	}
	
	//http://localhost:8080/ShoppingCartFrontEnd/manage_category_edit/cat001
	@RequestMapping("/manage_category_edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id){
		
		log.debug("Starting of editCategory");
		log.debug("going to egit category " + id);
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		category = categoryDAO.getCategoryByID(id);
		//Selected category details we have to store in another instance
		//in ModelAndView instance
		
		mv.addObject("selectedCategory", category);
		log.debug("End of editcategory");
		return mv;
	}
	
	@PostMapping("/manage_category_update")
	//@RequestMapping("/manage_category_edit/manage_category_update")
	public ModelAndView updateCategory(@RequestParam("id") String id,@RequestParam("name") String name,
			@RequestParam("description") String description){
	
		    //log.debug("Starting of the method createCategory");
			category.setId(id);
			category.setName(name);
			category.setDescription(description);			
			
		//	ModelAndView mv = new ModelAndView("Home");
			ModelAndView mv = new ModelAndView("redirect:/manageCategories");
			mv.addObject("isAdminClickedCategories","true");
			mv.addObject("isAdmin","true");
			
			//Before calling save check if exists
			if(categoryDAO.getCategoryByID(id) ==null){
				mv.addObject("message","Catgory doesn't exist with id  " + id);
				return mv;
			} else {
				categoryDAO.update(category);
				mv.addObject("message","Category Updated succssfully");
			}
			
			//to get updated data after adding/deleting
			session.setAttribute("categoryList", categoryDAO.list());
			session.setAttribute("category", category);
			//  log.debug("Ending of the method createCategory");
		return mv;
	}
	

}
