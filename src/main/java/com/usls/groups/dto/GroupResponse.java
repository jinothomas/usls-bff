package com.usls.groups.dto;

import java.util.Date;

import com.usls.common.dto.ResponseTemplate;
import com.usls.common.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse extends ResponseTemplate {
	
	private Long id;

	private String name;

	private Status status;

	private Date activeDateFrom;

	private Date activeDateTo;
}
