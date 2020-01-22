package com.project.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.User;
import com.project.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private IUserService userservice;
	
	@PostConstruct
	public void myinit(){
		System.out.println(getClass().getName()+"  --myinit");
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody User u)
	{
		try {
			System.out.println(getClass().getName()+" u = "+u);
			User u1 = userservice.validateUser(u);
			System.out.println("after db "+u1);
			return new ResponseEntity<User>(u1, HttpStatus.OK);			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User u)
	{
		if( userservice.registerUser(u) )
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return new ResponseEntity<String>("FAILURE",HttpStatus.EXPECTATION_FAILED);
	}
	
	@PostMapping("/getPassword")
	public ResponseEntity<?> getPassword(@RequestBody String username)
	{
		System.out.println("username : "+username);
		User u = userservice.getPassword(username);
		if( u != null)
			return new ResponseEntity<User>(u, HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody User u)
	{
		if( userservice.changePassword(u) )
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return new ResponseEntity<String>("FAILURE",HttpStatus.BAD_REQUEST);
	}
	
}
