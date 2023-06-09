package com.phase2.FlyAway.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase2.FlyAway.model.User;
import com.phase2.FlyAway.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
		
	}
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@PostMapping("/add_user")
	public int createUser(@RequestBody User user) {
		userService.createUser(user);
		return user.getId();
	}

}
