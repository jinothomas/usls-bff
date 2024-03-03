package com.usls.permission.service;

import java.util.Set;
import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.usls.common.exception.PermissionNotFoundException;
import com.usls.permission.dto.PermissionRequest;
import com.usls.permission.dto.PermissionResponse;
import com.usls.permission.entity.Permission;
import com.usls.permission.mapper.PermissionModelMapper;
import com.usls.permission.repository.PermissionRepository;

@Service
public class PermissionService {
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private PermissionModelMapper permissionModelMapper;

	public PermissionResponse createPermission(PermissionRequest request) {
		Permission roleManagement = permissionRepository.save(permissionModelMapper.mapRequestToEntity(request));
		return permissionModelMapper.mapEntityToResponse(roleManagement);
	}

	public PermissionResponse getPermission(Long roleManagementId) {
		Permission roleManagement = permissionRepository.findById(roleManagementId).orElseThrow(()-> new PermissionNotFoundException("Permission Not Found"));
		return permissionModelMapper.mapEntityToResponse(roleManagement);
	}

	public Set<PermissionResponse> getAllPermissions() {
		Set<PermissionResponse> roleManagements = new HashSet<>();
		if (permissionRepository.count() > 0) {
			permissionRepository.findAll().stream().forEach(user -> {
				roleManagements.add(permissionModelMapper.mapEntityToResponse(user));
			});
		}else {
			throw new PermissionNotFoundException("No Permissions Found!");
		}
		return roleManagements;
	}

	public String deletePermission(Long roleManagementId) {
		if (permissionRepository.existsById(roleManagementId)) {
			permissionRepository.deleteById(roleManagementId);
			return roleManagementId.toString();
		} else {
			throw new PermissionNotFoundException("Permission Not Found");
		}
	}

	public String updatePermission(Long roleManagementId, PermissionRequest request) {
		Permission roleManagement = permissionRepository.findById(roleManagementId).orElseThrow(()-> new PermissionNotFoundException("Permission Not Found"));
		permissionRepository.save(permissionModelMapper.updateEntityWithRequest(request, roleManagement));
		return "Updated Successfully";
	}

}
