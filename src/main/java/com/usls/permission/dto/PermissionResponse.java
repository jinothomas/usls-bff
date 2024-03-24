package com.usls.permission.dto;

import com.usls.common.dto.ResponseTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionResponse extends ResponseTemplate {
	
	private String name;

	private Long roleId;
	
	private String description;

	private String permissionType;
}
