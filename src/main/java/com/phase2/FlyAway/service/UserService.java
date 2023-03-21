package com.phase2.FlyAway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase2.FlyAway.model.User;
import com.phase2.FlyAway.repo.UserReop;

@Service
public class UserService {
	@Autowired
	UserReop userRepo;
	
	public User getUserById(int id) {
		return userRepo.findById(id).get();
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		userRepo.findAll().forEach(user -> users.add(user));
		return users;
	}
	
	public void createUser(User user) {
	
		userRepo.save(user);
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
}
