package com.hr_portal.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hr_portal.entity.User;
import com.hr_portal.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {

	@Autowired
	public UserService userService;
	
	// GET THE DATA
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	// GIEV THE USERNAME AND PASSWORD FOR LOGIN
	@PostMapping("/login")
	public String login (@ModelAttribute ("user") User user) {
		User oathUser = userService.login(user.getUsername(), user.getPassword());
		
		System.out.println(oathUser);
		if (Objects.nonNull(oathUser)){
			return "redirect:/hr_portal";
		}else {
			return "login";
		}
	}
	

	
	// LOGOUT
//	@RequestMapping(value= {"/logout"}, method = RequestMethod.POST)
//	public String logout(HttpServletRequest reques, HttpServletResponse response){
//	           return "redirect:/login";		
//	}
	
	
	
}
