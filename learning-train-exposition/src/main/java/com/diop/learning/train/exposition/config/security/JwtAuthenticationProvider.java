package com.diop.learning.train.exposition.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication arg0) {
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

}
