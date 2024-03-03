package com.usls.common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ResponseTemplate {
	
	private String createdBy;
	
	private String lastModifiedBy;
	
	private Date createdDate;
	
	private Date lastModifiedDate;
}
