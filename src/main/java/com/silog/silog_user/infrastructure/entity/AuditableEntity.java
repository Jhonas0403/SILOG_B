package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base class for all auditable entities.
 *
 * Why: Avoids duplicating created_at / updated_at / created_by / updated_by
 * in every entity. Spring Data JPA fills these automatically when
 * @EnableJpaAuditing is active (see AuditingConfig).
 *
 * How it works:
 * - @CreatedDate  → set once on INSERT, never updated
 * - @LastModifiedDate → updated on every UPDATE
 * - @CreatedBy    → reads from AuditorAware<UUID> bean
 * - @LastModifiedBy → same
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class AuditableEntity {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private UUID createdBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    private UUID updatedBy;
}
