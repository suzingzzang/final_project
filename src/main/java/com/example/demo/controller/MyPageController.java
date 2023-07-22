package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Payment;
import com.example.demo.entity.User;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.example.demo.service.PaymentService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/mypage")
public class MyPageController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderDetailService orderDetailService;

	@Autowired
	PaymentService paymentService;

	@GetMapping("")
	public String getUserMyPage(Model model, Principal principal) {
		String email = principal.getName();
		User user = userService.getUserByEmail(email);
		List<OrderDetail> orderDetails = orderDetailService.findOrderDetailsByUser(user);
		List<Payment> paymentList = paymentService.findPaymentByUser(user);

		model.addAttribute("user", user);
		model.addAttribute("orderDetails", orderDetails);
		model.addAttribute("paymentList", paymentList);
		return "mypage";
	}

}
