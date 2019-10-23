package com.brs.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brs.services.BusInfoServices;
import com.brs.services.BusInfoServicesImpl;

@Controller
public class AdminController {
	
	@Resource
	private BusInfoServices bis;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginValidate(ModelMap model, @RequestParam("username") String username,@RequestParam("password") String password) {
		if (!bis.isvalidUser(username, password)) {
			System.out.println("validateUser method...");
			return "login";
		}

		model.put("name", username);
		return "success";
	}

}
