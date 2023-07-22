package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;


@RestController
public class SignUpRestController {

   @Autowired
   private UserService userService;
   
   @PostMapping("/sign/check_email")
   public String checkDuplicateEmail(@Param("id") Integer id, @Param("email") String email) {
	   System.err.println(">>>>>>>>>>>>>>>id>>>>"+id);
	   System.err.println(">>>>>>>>>>>>>>>email>>>>"+email);
	   System.err.println("@PostMapping(/sign/check_email)");
      return userService.isEmailUnique(id, email) ? "OK" : "Duplicated";
   }
}