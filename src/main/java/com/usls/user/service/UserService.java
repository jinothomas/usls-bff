package com.usls.user.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usls.common.exception.UserNotFoundException;
import com.usls.user.dto.UserRequest;
import com.usls.user.dto.UserResponse;
import com.usls.user.entity.User;
import com.usls.user.mapper.UserModelMapper;
import com.usls.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserModelMapper userModelMapper;
	
	public UserResponse createUser(UserRequest request) {
		User user = userRepository.save(userModelMapper.mapRequestToEntity(request));
		return userModelMapper.mapEntityToResponse(user);
	}
	
	public String updateUser(UUID userId, UserRequest request) {
		User user = userRepository.findByUserId(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));
		userRepository.save(userModelMapper.updateEntityWithRequest(request, user));
		return "Updated Successfully";
	}
	
	public String deleteUser(UUID userId) {
		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return userId.toString();
		} else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	public UserResponse getUser(UUID userId) {
		User user = userRepository.findByUserId(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));
		return userModelMapper.mapEntityToResponse(user);
	}
	
	public Set<UserResponse> getAllUsers() {
		Set<UserResponse> users = new HashSet<>();
		if (userRepository.count() > 0) {
			userRepository.findAll().stream().forEach(user -> {
				users.add(userModelMapper.mapEntityToResponse(user));
			});
		}else {
			throw new UserNotFoundException("No Users Found!");
		}
		return users;
	}
}
