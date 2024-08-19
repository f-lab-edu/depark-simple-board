package com.example.simpleboard.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "REG_DT", updatable = false)
    private LocalDateTime regDt;

    @LastModifiedDate
    @Column(name = "MOD_DT")
    private LocalDateTime modDt;

}
