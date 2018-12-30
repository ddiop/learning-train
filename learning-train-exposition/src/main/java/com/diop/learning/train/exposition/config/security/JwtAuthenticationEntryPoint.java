package com.diop.learning.train.exposition.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * JwtAuthentication EntryPoint
 * 
 * @author b49543
 *
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse httpServletResponse, AuthenticationException authExc) throws IOException, ServletException {
		httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden: Authorization connexion data was either missing or invalid.");

	}

}
