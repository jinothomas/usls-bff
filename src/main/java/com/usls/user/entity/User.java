package com.usls.user.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.usls.common.entity.Auditor;
import com.usls.role.entity.Role;
import com.usls.user.enums.UserEnums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="USLS_USERS")
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditor<String>{
	
	@Id
	@UuidGenerator(style = UuidGenerator.Style.RANDOM)
	@Column(name="USER_ID", updatable = false, nullable = false)
	private UUID userId;
	
	@Column(name="NAME", nullable = false, unique = false)
	private String name;
	
	@OneToOne
	@JoinColumn(name="ROLE_ID", nullable = false)
	private Role role;
	
	@Column(name="EMAIL", nullable = false, unique = false)
	private String email;
	
	@Column(name="PASSWORD", nullable = false, unique = false)
	private String password;
	
	@Column(name="MOBILE_NUMBER", nullable = true, unique = false)
	private String mobileNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="USER_STATUS")
	private UserStatus userStatus;
	
}
