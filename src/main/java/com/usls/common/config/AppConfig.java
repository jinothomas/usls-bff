package com.usls.common.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = "com.usls")
public class AppConfig {
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	AuditorAware<String> auditorAware() {
	   return new AuditorAwareImpl();
	}
}
