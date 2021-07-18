package com.datastax.examples.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("users/add")
	public ResponseEntity<String> addUser(@RequestBody User user){
		
		userService.addUser(user);
		
		return ResponseEntity.ok(user.getFirstName());
		
	}

}
