package com.usls.role.mapper;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usls.common.enums.Status;
import com.usls.common.mapper.ApplicationModelMapper;
import com.usls.role.dto.RoleRequest;
import com.usls.role.dto.RoleResponse;
import com.usls.role.entity.Role;

@Component
public class RoleModelMapper implements ApplicationModelMapper<RoleRequest, RoleResponse, Role>{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Role mapRequestToEntity(RoleRequest roleRequest) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(roleRequest, Role.class);
	}
	
	@Override
	public RoleResponse mapEntityToResponse(Role role) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(role, RoleResponse.class);
	}
	
	@Override
	public Role updateEntityWithRequest(RoleRequest roleRequest, Role role) {
		role.setName((String)getValidData(roleRequest.getName(), role.getName()));
		role.setStatus((Status)getValidData(roleRequest.getStatus(), role.getStatus()));
		role.setPriority((Integer)getValidData(roleRequest.getPriority(), role.getPriority()));
		return role;
	}
	
	private Object getValidData(Object newValue, Object existingValue) {
		return ObjectUtils.isNotEmpty(newValue) ? newValue : existingValue;
	}

}
