package com.usls.groups.entity;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.usls.common.entity.Auditor;
import com.usls.common.enums.Status;
import com.usls.role.entity.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USLS_GROUPS")
@EntityListeners(AuditingEntityListener.class)
public class Group extends Auditor<String> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name="NAME", nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name="STATUS", nullable = false)
	private Status status;

	@Column(name="ACTIVE_DATE_FROM")
	private Date activeDateFrom;

	@Column(name="ACTIVE_DATE_TO")
	private Date activeDateTo;
	
	@OneToMany(mappedBy = "group")
	private Set<Role> roles;
}
