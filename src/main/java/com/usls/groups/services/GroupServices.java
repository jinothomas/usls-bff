package com.usls.groups.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usls.common.exception.GroupNotFoundException;
import com.usls.groups.dto.GroupRequest;
import com.usls.groups.dto.GroupResponse;
import com.usls.groups.entity.Group;
import com.usls.groups.mapper.GroupModelMapper;
import com.usls.groups.repository.GroupRepository;

@Service
public class GroupServices {
	
	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	GroupModelMapper groupModelMapper;

	public GroupResponse createGroup(GroupRequest request) {
		Group group = groupRepository.save(groupModelMapper.mapRequestToEntity(request));
		return groupModelMapper.mapEntityToResponse(group);
	}

	public GroupResponse getGroup(Long groupId) {
		Group user = groupRepository.findById(groupId).orElseThrow(()-> new GroupNotFoundException("Group Not Found"));
		return groupModelMapper.mapEntityToResponse(user);
	}

	public Set<GroupResponse> getAllGroups() {
		Set<GroupResponse> groups = new HashSet<>();
		if (groupRepository.count() > 0) {
			groupRepository.findAll().stream().forEach(user -> {
				groups.add(groupModelMapper.mapEntityToResponse(user));
			});
		}else {
			throw new GroupNotFoundException("No Groups Found!");
		}
		return groups;
	}

	public String deleteGroup(Long groupId) {
		if (groupRepository.existsById(groupId)) {
			groupRepository.deleteById(groupId);
			return groupId.toString();
		} else {
			throw new GroupNotFoundException("Group Not Found");
		}
	}

	public String updateGroup(Long groupId, GroupRequest groupRequest) {
		Group user = groupRepository.findById(groupId).orElseThrow(()-> new GroupNotFoundException("Group Not Found"));
		groupRepository.save(groupModelMapper.updateEntityWithRequest(groupRequest, user));
		return "Updated Successfully";
	}

}
