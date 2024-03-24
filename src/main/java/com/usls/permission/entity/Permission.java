package com.usls.permission.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.usls.common.entity.Auditor;
import com.usls.role.entity.Role;
import com.usls.role.enums.RolePermissions.Permission.PermissionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="USLS_PERMISSIONS")
@EntityListeners(AuditingEntityListener.class)
public class Permission extends Auditor<String> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID", nullable = false)
	private Role role;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE", nullable = false)
	private PermissionType permissionType;
	
}
