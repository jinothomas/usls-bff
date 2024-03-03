package com.usls.common.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@KeycloakConfiguration
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	private final JwtAuthConverter jwtAuthConverter;

	  
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.sessionManagement((session)->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.csrf((csrf)->csrf.disable())
		.cors((cors)->cors.configurationSource(null))
		.authorizeHttpRequests((auth)-> auth.requestMatchers("/**").permitAll())
		.oauth2ResourceServer((oauth2)->oauth2.jwt((jwt)->jwt.jwtAuthenticationConverter(jwtAuthConverter)));
		
		return http.build();
	  }
}
