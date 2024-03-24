package com.usls.user.controller;

import java.util.Set;
import java.util.UUID;

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
import com.usls.user.enums.UserEnums.UserStatus;
import com.usls.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
		request.setUserStatus(UserStatus.NEW);
		return ResponseEntity.ok(userService.createUser(request));
	}
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId) {
		return ResponseEntity.ok(userService.getUser(UUID.fromString(userId)));
	}
	
	@GetMapping("/get")
	public ResponseEntity<Set<UserResponse>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
		return ResponseEntity.ok(userService.deleteUser(UUID.fromString(userId)));
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable("userId") String userId, @RequestBody UserRequest userRequest) {
		return ResponseEntity.ok(userService.updateUser(UUID.fromString(userId), userRequest));
	}
}
