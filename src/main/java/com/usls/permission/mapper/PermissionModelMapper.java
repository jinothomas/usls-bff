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
	public Permission mapRequestToEntity(PermissionRequest roleRequest) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(roleRequest, Permission.class);
	}
	
	@Override
	public PermissionResponse mapEntityToResponse(Permission roleManagement) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(roleManagement, PermissionResponse.class);
	}
	
	@Override
	public Permission updateEntityWithRequest(PermissionRequest roleRequest, Permission permission) {
		permission.setName((String)getValidData(roleRequest.getName(), permission.getName()));
		permission.setDescription((String)getValidData(roleRequest.getDescription(), permission.getDescription()));
		permission.setPermissionType((PermissionType)getValidData(roleRequest.getStatus(), permission.getPermissionType()));
		return permission;
	}
	
	private Object getValidData(Object newValue, Object existingValue) {
		return ObjectUtils.isNotEmpty(newValue) ? newValue : existingValue;
	}

}
