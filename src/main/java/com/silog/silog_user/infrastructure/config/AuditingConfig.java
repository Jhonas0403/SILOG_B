package com.silog.silog_user.infrastructure.config;

import com.silog.silog_user.infrastructure.security.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

/**
 * Enables JPA Auditing so that @CreatedDate, @LastModifiedDate,
 * @CreatedBy and @LastModifiedBy in AuditableEntity are filled automatically.
 *
 * AuditorAware: Spring asks this bean "who is the current user?"
 * Right now it returns empty (no JWT yet). When you add authentication later,
 * replace the placeholder with: UUID.fromString(authentication.getName())
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditingConfig {

    @Bean
    public AuditorAware<UUID> auditorProvider() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .filter(Authentication::isAuthenticated)
                .filter(auth -> !"anonymousUser".equals(auth.getPrincipal()))
                .map(auth -> {
                    try {
                        Object principal = auth.getPrincipal();
                        String userId = (principal instanceof UserPrincipal up)
                                ? up.getUserId()
                                : auth.getName();
                        return UUID.fromString(userId);
                    } catch (IllegalArgumentException e) {
                        return null;
                    }
                });
    }
}
