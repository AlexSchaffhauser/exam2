package com.johnabbott.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.login.model.User;
import com.johnabbott.login.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("home-page");
		mv.addObject("user", new User());

		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView("login-page");
		mv.addObject("user", new User());

		return mv;
	}
	
	@RequestMapping("/registration")
	public ModelAndView registrationPage() {
		ModelAndView mv = new ModelAndView("register-page");
		mv.addObject("user", new User());

		return mv;
	}
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User usr) {
		if (service.addUser(usr))
			return "redirect:/home";
		else {
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value = "verifyUser", method = RequestMethod.GET)
	public String verifyUser(@RequestParam("email") String userEmail, @RequestParam("password") String userPassword) {
		if (service.verifyUser(userEmail, userPassword))
			return "redirect:/home";
		else {
			return "redirect:/registration";
		}
	}
}
