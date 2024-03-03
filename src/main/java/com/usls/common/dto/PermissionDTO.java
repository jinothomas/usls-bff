package com.usls.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PermissionDTO {
	
	private String name;
	
	private String feature;
	
	private String description;
	
	private String aspectType;
	
	private String permissionType;
	
}
