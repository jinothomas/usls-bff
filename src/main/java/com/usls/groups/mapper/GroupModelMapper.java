package com.usls.groups.mapper;

import java.util.Date;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usls.groups.entity.Group;
import com.usls.common.enums.Status;
import com.usls.groups.dto.GroupRequest;
import com.usls.groups.dto.GroupResponse;
import com.usls.common.mapper.ApplicationModelMapper;

@Component
public class GroupModelMapper implements ApplicationModelMapper<GroupRequest, GroupResponse, Group>{
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Group mapRequestToEntity(GroupRequest groupRequest) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(groupRequest, Group.class);
	}

	@Override
	public GroupResponse mapEntityToResponse(Group group) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(group, GroupResponse.class);
	}

	@Override
	public Group updateEntityWithRequest(GroupRequest groupRequest, Group group) {
		group.setName((String)getValidData(groupRequest.getName(), group.getName()));
		group.setStatus((Status)getValidData(groupRequest.getStatus(), group.getStatus()));
		group.setActiveDateFrom((Date)getValidData(groupRequest.getActiveDateFrom(), group.getActiveDateFrom()));
		group.setActiveDateTo((Date)getValidData(groupRequest.getActiveDateTo(), group.getActiveDateTo()));
		return group;
	}
	
	private Object getValidData(Object newValue, Object existingValue) {
		return ObjectUtils.isNotEmpty(newValue) ? newValue : existingValue;
	}
	
	
}
