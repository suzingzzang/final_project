package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	BookService bookService;

	@Autowired
	UserService userService;

	@PostMapping("/save/{userId}")
	public String update(Model theModel, Principal principal, @RequestParam("userId") Integer userId) {
		theModel.addAttribute("user", userId);
		return "signUpPage";
	}

	@GetMapping("/delete/{userId}")
	public String deleteById(@PathVariable(name = "userId") int userId) {
		userService.delete(userId);
		return "home";
	}

	@GetMapping("/update/{userId}")
	   public String editUser(@PathVariable(name = "userId") int userId, Model model, RedirectAttributes rttr)
	         throws Exception {

	      User user = userService.get(userId);
	      model.addAttribute("user", user);
	      if (user.getPassword() != null) {
	         String check = "yes";
	         model.addAttribute("check", check);
	      }
	      model.addAttribute("edit","a");

	      return "signUpPage";

	   }

}