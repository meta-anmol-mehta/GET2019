package com.metacube.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.User;
import com.metacube.training.service.UserService;

/**
 * class to control the user flow on the website
 * @author admin
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("x",new User());
		return "user/add";
		
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(User user) {
		try{
		userService.add(user);
		return "redirect:/user/all";
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}

	
	
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public ModelAndView get( @PathVariable("userId") Integer userId) {
		try{
		User user = userService.get(userId);
		return new ModelAndView("user/edit", "user",user);
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user) {
		try{
		userService.update(user);
		return "redirect:/user/all";
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAll() {
		try{
		List<User> users = userService.getAll(); 
		return new ModelAndView("user/all", "users", users);
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String delete(@PathVariable("userId") Integer userId) {
		try{
		userService.delete(userId);
		return "redirect:/user/all";
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search() {
	
		return "user/search";
	}
	@RequestMapping(value = "/search_result", method = RequestMethod.GET)
    public ModelAndView searchResult(String attribute, String attribute_value) {
        try{
	List<User> user = userService.getByAttribute(attribute,attribute_value); 
        return new ModelAndView("user/search_result", "user", user);
	}
	catch(NullPointerException e){
	MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
	}
    }
}
