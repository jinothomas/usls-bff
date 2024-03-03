package com.usls.common.entity;

import lombok.Data;
import java.util.Date;
import jakarta.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditor<U> {
	@CreatedBy
    protected U createdBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @LastModifiedBy
    protected U lastModifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;

}
