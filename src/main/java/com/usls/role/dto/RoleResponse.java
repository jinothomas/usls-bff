package com.usls.role.dto;

import com.usls.common.dto.ResponseTemplate;
import com.usls.common.enums.Status;
import com.usls.groups.dto.GroupResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse extends ResponseTemplate {
	
	private String name;

	private Status status;

	private Integer priority;
	
	private String description;
	
	private GroupResponse group;
}
