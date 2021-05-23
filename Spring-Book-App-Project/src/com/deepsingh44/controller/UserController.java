package com.deepsingh44.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.deepsingh44.dao.UserDao;
import com.deepsingh44.model.User;
import com.deepsingh44.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/register")
	@ResponseBody
	public String addUser(User user) {
		int i = userService.register(user);
		if (i > 0) {
			return "Successfully Register";
		} else {
			return "Registration Failed";
		}
	}

	@PostMapping("/user/login")
	@ResponseBody
	public String loginUser(String email, String pass, HttpSession session) {
		User user = userService.login(email, pass);
		if (user != null) {
			session.setAttribute("user", user);
			return "Successfully Login";
		} else {
			return "Invalid Email or Password";
		}
	}
	

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/";
	}

}
