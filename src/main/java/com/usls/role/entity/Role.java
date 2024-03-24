package com.usls.role.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import com.usls.common.enums.Status;
import com.usls.groups.entity.Group;
import com.usls.common.entity.Auditor;
import com.usls.permission.entity.Permission;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@Table(name="USLS_ROLES")
@EntityListeners(AuditingEntityListener.class)
public class Role extends Auditor<String>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID", nullable = false)
	private Group group;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	@Column(name="PRIORITY", nullable = false)
	private Integer priority;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS", nullable = false)
	private Status status;
	
	@OneToMany(mappedBy = "role")
	private Set<Permission> permissions;
}
