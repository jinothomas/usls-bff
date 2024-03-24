package com.usls.permission.mapper;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usls.common.mapper.ApplicationModelMapper;
import com.usls.permission.dto.PermissionRequest;
import com.usls.permission.dto.PermissionResponse;
import com.usls.permission.entity.Permission;
import com.usls.role.enums.RolePermissions.Permission.PermissionType;


@Component
public class PermissionModelMapper
		implements ApplicationModelMapper<PermissionRequest, PermissionResponse, Permission>{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Permission mapRequestToEntity(PermissionRequest permissionRequest) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(permissionRequest, Permission.class);
	}
	
	@Override
	public PermissionResponse mapEntityToResponse(Permission permission) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(permission, PermissionResponse.class);
	}
	
	@Override
	public Permission updateEntityWithRequest(PermissionRequest permissionRequest, Permission permission) {
		permission.setName((String)getValidData(permissionRequest.getName(), permission.getName()));
		permission.setDescription((String)getValidData(permissionRequest.getDescription(), permission.getDescription()));
		permission.setPermissionType((PermissionType)getValidData(permissionRequest.getStatus(), permission.getPermissionType()));
		return permission;
	}
	
	private Object getValidData(Object newValue, Object existingValue) {
		return ObjectUtils.isNotEmpty(newValue) ? newValue : existingValue;
	}

}
