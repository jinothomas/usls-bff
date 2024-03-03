package com.usls.groups.dto;

import java.util.Date;

import com.usls.common.enums.Status;

import lombok.Data;

@Data
public class GroupResponse {
	
	private Long id;

	private String name;

	private Status status;

	private Date activatedDateFrom;

	private Date activatedDateTo;
}
