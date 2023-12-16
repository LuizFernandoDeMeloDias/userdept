package com.devsuperior.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository respository;
	
	
	@GetMapping
	public List<User> findAll(){
		List<User> result = respository.findAll();
		return result;
		
	}
	
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id){
		User result = respository.findById(id).get();
		return result;
		
	}
	
	
	@PostMapping
	public User insert(@RequestBody User user){
		User result = respository.save(user);
		return result;
		
	}
}
