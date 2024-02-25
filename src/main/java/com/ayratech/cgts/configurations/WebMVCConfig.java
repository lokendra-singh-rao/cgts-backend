package com.ayratech.cgts.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(final CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/graphql/**")
		.allowedOrigins(CorsConfiguration.ALL)
		.allowedHeaders(CorsConfiguration.ALL)
		.allowedMethods(CorsConfiguration.ALL);
	}
}
