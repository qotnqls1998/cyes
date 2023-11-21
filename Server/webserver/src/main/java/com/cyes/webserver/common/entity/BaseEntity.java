package com.cyes.webserver.common.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity{

    @CreatedDate
    @Column(name ="created_date",updatable = false)
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDateTime;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDateTime;
}
