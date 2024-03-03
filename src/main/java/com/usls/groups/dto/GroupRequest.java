package com.usls.groups.dto;

import java.util.Date;

import com.usls.common.enums.Status;

import lombok.Data;

@Data
public class GroupRequest {
	
	private String name;
	
	private Status status;
	
	private Date activeDateFrom;
	
	private Date activeDateTo;
}
