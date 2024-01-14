package com.usls.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USLS_USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="NAME", length = 50, nullable = false, unique = false)
	private String name;
	
	@Column(name="EMAIL", length = 50, nullable = false, unique = false)
	private String email;
	
	@Column(name="DEPARTMENT", length = 20, nullable = false, unique = false)
	private String Department;
	
	@Column(name="MOBILE_NUMBER", length = 11, nullable = true, unique = false)
	private String mobileNumber;
}
