package com.usls.user.dto;

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
	
	private String password;
	
	private String Department;
	
	private String mobileNumber;
	
}
