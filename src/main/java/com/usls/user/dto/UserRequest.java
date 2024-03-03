package com.usls.user.dto;

import com.usls.user.enums.UserEnums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	
	private String name;
	
	private String email;
	
	private UserStatus userStatus;
	
	private String password;
	
	private String department;
	
	private String mobileNumber;
	
}
