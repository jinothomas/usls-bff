package com.usls.permission.controller;

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

import com.usls.permission.dto.PermissionRequest;
import com.usls.permission.dto.PermissionResponse;
import com.usls.permission.service.PermissionService;



@RestController
@RequestMapping(value = "/permission")
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;
	
	@PostMapping("/create")
	public ResponseEntity<PermissionResponse> createPermission(@RequestBody PermissionRequest request) {
		return ResponseEntity.ok(permissionService.createPermission(request));
	}
	
	@GetMapping("/get/{permissionId}")
	public ResponseEntity<PermissionResponse> getPermission(@PathVariable("permissionId") Long permissionId) {
		return ResponseEntity.ok(permissionService.getPermission(permissionId));
	}
	
	@GetMapping("/get")
	public ResponseEntity<Set<PermissionResponse>> getAllPermissions() {
		return ResponseEntity.ok(permissionService.getAllPermissions());
	}
	
	@DeleteMapping("/delete/{permissionId}")
	public ResponseEntity<String> deletePermission(@PathVariable("permissionId") Long permissionId) {
		return ResponseEntity.ok(permissionService.deletePermission(permissionId));
	}
	
	@PutMapping("/update/{permissionId}")
	public ResponseEntity<String> updatePermission(@PathVariable("permissionId") Long permissionId, @RequestBody PermissionRequest request) {
		return ResponseEntity.ok(permissionService.updatePermission(permissionId, request));
	}
}
