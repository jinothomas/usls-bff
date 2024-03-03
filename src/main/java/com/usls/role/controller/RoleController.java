package com.usls.role.controller;

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

import com.usls.role.dto.RoleRequest;
import com.usls.role.dto.RoleResponse;
import com.usls.role.service.RoleService;


@RestController
@RequestMapping(value = "/roles")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PostMapping("/createRole")
	public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest request) {
		return ResponseEntity.ok(roleService.createRole(request));
	}
	
	@GetMapping("/getRole/{roleId}")
	public ResponseEntity<RoleResponse> getRole(@PathVariable("roleId") Long roleId) {
		return ResponseEntity.ok(roleService.getRole(roleId));
	}
	
	@GetMapping("/getAllRoles")
	public ResponseEntity<Set<RoleResponse>> getAllRoles() {
		return ResponseEntity.ok(roleService.getAllRoles());
	}
	
	@DeleteMapping("/deleteRole/{roleId}")
	public ResponseEntity<String> deleteRole(@PathVariable("roleId") Long roleId) {
		return ResponseEntity.ok(roleService.deleteRole(roleId));
	}
	
	@PutMapping("/updateRole/{roleId}")
	public ResponseEntity<String> updateRole(@PathVariable("roleId") Long roleId, @RequestBody RoleRequest RoleRequest) {
		return ResponseEntity.ok(roleService.updateRole(roleId, RoleRequest));
	}
}
