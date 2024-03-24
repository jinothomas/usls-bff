package com.usls.user.dto;

import java.util.UUID;

import com.usls.common.dto.ResponseTemplate;
import com.usls.role.dto.RoleResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends ResponseTemplate {

	private UUID userId;

	private String name;

	private String email;

	private String mobileNumber;
	
	private String userStatus;
	
	private RoleResponse role;
}
