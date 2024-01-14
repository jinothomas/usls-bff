package com.usls.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usls.user.dto.UserRequest;
import com.usls.user.dto.UserResponse;
import com.usls.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<Long> createUser(@RequestBody UserRequest request) {
		return ResponseEntity.ok(userService.createUser(request));
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(userService.deleteUser(userId));
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable("userId") Long userId, @RequestBody UserRequest userRequest) {
		return ResponseEntity.ok(userService.updateUser(userId, userRequest));
	}
}
