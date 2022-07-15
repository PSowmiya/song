package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.userDetails;
import com.example.demo.Service.UserService;

@RestController()
@RequestMapping("/api")
public class UserController {

	@Autowired
	private  UserService userService;

	
	@PostMapping("/save")
	public String saveUserDetails(@RequestBody userDetails userDTO) throws Exception {
	return	userService.saveUserDetails(userDTO);
	}
	
	
}
