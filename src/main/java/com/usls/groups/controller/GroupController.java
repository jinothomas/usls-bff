package com.usls.groups.controller;

import java.util.Set;

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

import com.usls.groups.dto.GroupRequest;
import com.usls.groups.dto.GroupResponse;
import com.usls.groups.services.GroupServices;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {
	
	@Autowired
	GroupServices groupServices;
	
	@PostMapping("/createGroup")
	public ResponseEntity<GroupResponse> createGroup(@RequestBody GroupRequest request) {
		return ResponseEntity.ok(groupServices.createGroup(request));
	}
	
	@GetMapping("/getGroup/{groupId}")
	public ResponseEntity<GroupResponse> getGroup(@PathVariable("groupId") Long groupId) {
		return ResponseEntity.ok(groupServices.getGroup(groupId));
	}
	
	@GetMapping("/getAllGroups")
	public ResponseEntity<Set<GroupResponse>> getAllGroups() {
		return ResponseEntity.ok(groupServices.getAllGroups());
	}
	
	@DeleteMapping("/deleteGroup/{groupId}")
	public ResponseEntity<String> deleteGroup(@PathVariable("groupId") Long groupId) {
		return ResponseEntity.ok(groupServices.deleteGroup(groupId));
	}
	
	@PutMapping("/updateGroup/{groupId}")
	public ResponseEntity<String> updateGroup(@PathVariable("groupId") Long groupId, @RequestBody GroupRequest GroupRequest) {
		return ResponseEntity.ok(groupServices.updateGroup(groupId, GroupRequest));
	}
}