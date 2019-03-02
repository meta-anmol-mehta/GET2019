package com.metacube.training.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.interfaces.UserService;


/**
 * controller for the startup of application
 * @author admin
 *
 */

@Controller
public class WebSiteController {

	 @Autowired
	private UserService userService;
	  
	
	  @RequestMapping(value = "welcome", method = RequestMethod.GET)
	    public ModelAndView welcome( String username, String password) {
	      	 
		  return new ModelAndView("welcome", "usersCredentials", userService.getUsers(username, password));
	    }
	    
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String login() {
	        
		    return "login";
		    
		  
		  
	    }
	  @RequestMapping(value = "login", method = RequestMethod.GET)
	    public String logout() {
	        
		    return "login";
		    
		  
		  
	    }
}
