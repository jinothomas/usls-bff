package com.usls.user.mapper;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usls.common.mapper.ApplicationModelMapper;
import com.usls.user.dto.UserRequest;
import com.usls.user.dto.UserResponse;
import com.usls.user.entity.User;
import com.usls.user.enums.UserEnums.UserStatus;

@Component
public class UserModelMapper implements ApplicationModelMapper<UserRequest, UserResponse, User>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public User mapRequestToEntity(UserRequest userRequest) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(userRequest, User.class);
	}
	
	@Override
	public UserResponse mapEntityToResponse(User user) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(user, UserResponse.class);
	}
	
	@Override
	public User updateEntityWithRequest(UserRequest userRequest, User user) {
		user.setName((String)getValidData(userRequest.getName(), user.getName()));
		user.setEmail((String)getValidData(userRequest.getEmail(), user.getEmail()));
		user.setMobileNumber((String)getValidData(userRequest.getMobileNumber(), user.getMobileNumber()));
		user.setUserStatus((UserStatus)getValidData(userRequest.getUserStatus(), user.getUserStatus()));
		return user;
	}
	
	private Object getValidData(Object newValue, Object existingValue) {
		return ObjectUtils.isNotEmpty(newValue) ? newValue : existingValue;
	}
}
