package com.usls.role.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.usls.common.dto.PermissionDTO;
import com.usls.role.enums.RolePermissions.Permission.Feature;
import com.usls.role.enums.RolePermissions.Permission.PermissionType;

import lombok.Getter;

public class RolePermissions {

	public enum Permission {

		// ---------API Related Permissions-------------------
		//System Management Permissions
		API_SYSTEM_ALL_OPS(Feature.SYSTEM, "All System APIs", AspectType.API, PermissionType.ALL_OPS),
		API_SYSTEM_READ_ONLY(Feature.SYSTEM, "READ System API", AspectType.API, PermissionType.READ_ONLY),
		
		// Group related permissions
		API_GROUP_ALL_OPS(Feature.GROUP, "All Group APIs", AspectType.API, PermissionType.ALL_OPS),
		API_GROUP_READ_ONLY(Feature.GROUP, "Read Group API", AspectType.API, PermissionType.READ_ONLY),

		// Role related permissions
		API_ROLE_ALL_OPS(Feature.ROLE, "All Role APIs", AspectType.API, PermissionType.ALL_OPS),
		API_ROLE_READ_ONLY(Feature.ROLE, "Read Role API", AspectType.API, PermissionType.READ_ONLY),

		// Role Management related permissions
		API_ROLE_MANAGEMENT_ALL_OPS(Feature.ROLE_MANAGEMENT, "All Role Management APIs",
				AspectType.API, PermissionType.ALL_OPS),
		API_ROLE_MANAGEMENT_READ_ONLY(Feature.ROLE_MANAGEMENT, "Read Role Management API",
				AspectType.API, PermissionType.READ_ONLY),

		// User related permissions
		API_USER_MANAGEMENT_ALL_OPS(Feature.USER, "All User APIs", AspectType.API, PermissionType.ALL_OPS),
		API_USER_MANAGEMENT_READ_ONLY(Feature.USER, "Read User API", AspectType.API, PermissionType.READ_ONLY),

		// ---------UI Related Permissions-------------------
		UI_SYSTEM_ALL_OPS(Feature.SYSTEM, "All System UI", AspectType.UI, PermissionType.ALL_OPS);

		@Getter
		private Feature feature;

		@Getter
		private String description;
		
		@Getter
		private AspectType aspectType;

		@Getter
		private PermissionType permissionType;

		Permission(Feature feature, String description, AspectType aspectType, PermissionType permissionType) {
			this.feature = feature;
			this.aspectType = aspectType;
			this.description = description;
			this.permissionType = permissionType;
		}

		public enum Feature {
			
			SYSTEM("System Management"),
			HEADER("Application header"),
			USER("User management and APIs"),
			GROUP("Group related operations"),
			REPORTS("Reports page and APIs"),
			HEATMAP("Heatmap page and APIs"),
			UPLOADS("Uploads page and APIs"),
			CONTROLS("Application controls"),
			DASHBOARD("Dashboard page and APIs"),
			NAVIGATION("Application Navigation"),
			ROLE("Role related operations and APIs"),
			ROLE_MANAGEMENT("Role Management tab and APIs"),
			AUTHENTICATION("Authentication related operations");

			@Getter
			private String description;

			Feature(String description) {
				this.description = description;
			}
		}

		public enum PermissionType {

			ALL_OPS("All Operations"),
			READ_ONLY("Read operation"),
			CREATE_ONLY("Create operation"),
			DELETE_ONLY("Delete operation"),
			UPDATE_ONLY("Update operation");

			PermissionType(String description) {
				this.description = description;
			}

			@Getter
			private String description;

		}
		
		public enum AspectType {
			
			API("API Related Features"),
			UI("UI Related Features");

			@Getter
			private String description;
			
			AspectType(String description) {
				this.description = description;
			}
		}

	}
	
	
	public static Set<PermissionDTO> getPermissionDTOByFeature(Feature feature) {
		Set<PermissionDTO> permissions = new HashSet<>();
		getPermissionByFeature(feature).forEach(permission->{
			permissions.add(
					new PermissionDTO(permission.name(), permission.getFeature().name(), permission.getDescription(),
							permission.getAspectType().name(), permission.getPermissionType().name()));
		});
		return permissions;
	}
	
	public static Set<PermissionDTO> getPermissionDTOByPermissionType(PermissionType roleManagementType) {
		Set<PermissionDTO> permissions = new HashSet<>();
		getPermissionByPermissionType(roleManagementType).forEach(permission->{
			permissions.add(new PermissionDTO(permission.name(), permission.getFeature().name(), permission.getDescription(),
					permission.getAspectType().name(), permission.getPermissionType().name()));
		});
		return permissions;
	}
	

	
	
	public static Set<Permission> getPermissionByFeature(Feature feature) {
		return Arrays.asList(Permission.values()).stream()
				.filter(permission -> permission.getFeature().equals(feature)).collect(Collectors.toSet());
	}
	
	public static Set<Permission> getPermissionByPermissionType(PermissionType roleManagementType) {
		return Arrays.asList(Permission.values()).stream()
				.filter(permission -> permission.getPermissionType().equals(roleManagementType)).collect(Collectors.toSet());
	}
}