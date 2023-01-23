package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.dao.IUser;
import com.examly.springapp.model.User;


@RestController
public class AuthController {

	@Autowired
	IUser iUser;
	

	@PostMapping("/login")
	public boolean login(@RequestBody User user){
		try {
		User u= iUser.getUseByUsername(user.getUsername());
		 if(u==null) {
			 return false;
		 }
		 else if (!u.getPassword().equals(user.getPassword())) 
			 return false;
            
		}catch (Exception e) {
			return false;
		}
		return true;		
	}
	

	@PostMapping("/signup")
	public boolean signup(@RequestBody User user){
		try {
			User u=iUser.save(user);
			if(u==null) {
				return false;
			}

			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
}
