package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.BookService;
import com.example.demo.service.UserService;
import com.example.demo.service.WishlistService;

@Controller
public class WishlistRestController {

	@Autowired
	private WishlistService wishListService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@PostMapping("/wish")
	@ResponseBody
	public int a(@RequestBody int bookId) {
		System.out.println(bookId);
		return bookId;
	}

}