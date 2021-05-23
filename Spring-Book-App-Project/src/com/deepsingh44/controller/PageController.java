package com.deepsingh44.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@GetMapping("/")
	public String mainPage() {
		return "index";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}

	@GetMapping("/addbook")
	public String addBookPage() {
		return "addbook";
	}
	
	@GetMapping("/update")
	public String updateBookPage() {
		return "update";
	}

	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	@GetMapping("/delete")
	public String delePage() {
		return "delete";
	}


}
