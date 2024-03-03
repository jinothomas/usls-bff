package com.usls.permission.dto;

import com.usls.common.enums.Status;

import lombok.Data;

@Data
public class PermissionResponse {
	
	private String name;

	private Long groupId;

	private Status status;

	private Integer priority;
}
