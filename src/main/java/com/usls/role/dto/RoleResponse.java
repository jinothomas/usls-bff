package com.usls.role.dto;

import com.usls.common.enums.Status;

import lombok.Data;

@Data
public class RoleResponse {
	
	private String name;

	private Status status;

	private Integer priority;
}
