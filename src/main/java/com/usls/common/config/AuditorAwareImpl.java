package com.usls.common.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(Optional.ofNullable(SecurityContextHolder.getContext()).map(SecurityContext::getAuthentication)
				.filter(Authentication::isAuthenticated).map(Authentication::getPrincipal).map(Jwt.class::cast).get().getClaim("name"));
	}

}
