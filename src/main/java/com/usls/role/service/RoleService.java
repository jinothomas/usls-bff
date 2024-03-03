package com.usls.role.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usls.role.entity.Role;
import com.usls.common.dto.FeatureDTO;
import com.usls.role.dto.RoleRequest;
import com.usls.role.dto.RoleResponse;
import com.usls.role.mapper.RoleModelMapper;
import com.usls.role.repository.RoleRepository;
import com.usls.role.util.RoleManagementUtil;
import com.usls.common.exception.RoleNotFoundException;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleModelMapper roleModelMapper;
	
	@Autowired
	private RoleManagementUtil roleManagementUtil;
	
	public RoleResponse createRole(RoleRequest request) {
		Role role = roleRepository.save(roleModelMapper.mapRequestToEntity(request));
		return roleModelMapper.mapEntityToResponse(role);
	}

	public RoleResponse getRole(Long roleId) {
		Role role = roleRepository.findById(roleId).orElseThrow(()-> new RoleNotFoundException("Role Not Found"));
		return roleModelMapper.mapEntityToResponse(role);
	}

	public Set<RoleResponse> getAllRoles() {
		Set<RoleResponse> roles = new HashSet<>();
		if (roleRepository.count() > 0) {
			roleRepository.findAll().stream().forEach(user -> {
				roles.add(roleModelMapper.mapEntityToResponse(user));
			});
		}else {
			throw new RoleNotFoundException("No Roles Found!");
		}
		return roles;
	}

	public String deleteRole(Long roleId) {
		if (roleRepository.existsById(roleId)) {
			roleRepository.deleteById(roleId);
			return roleId.toString();
		} else {
			throw new RoleNotFoundException("Role Not Found");
		}
	}

	public String updateRole(Long roleId, RoleRequest request) {
		Role role = roleRepository.findById(roleId).orElseThrow(()-> new RoleNotFoundException("Role Not Found"));
		roleRepository.save(roleModelMapper.updateEntityWithRequest(request, role));
		return "Updated Successfully";
	}
	
	public Set<FeatureDTO> getPermissions() {
		return roleManagementUtil.getAllFeatures();
	}

}
