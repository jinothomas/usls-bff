package com.usls.common.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleManagementTypeDTO {
	
	private String name;

	private String description;

	private Set<PermissionDTO> permissions;
}	
