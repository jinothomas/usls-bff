package com.usls.role.dto;

import com.usls.common.enums.Status;

import lombok.Data;

@Data
public class RoleRequest {
	
	private String name;
	
	private Long groupId;
	
	private Status status;
	
	private Integer priority;
	
	private String description;
	
}
