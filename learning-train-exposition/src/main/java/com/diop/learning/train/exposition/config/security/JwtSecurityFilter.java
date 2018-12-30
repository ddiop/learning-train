package com.diop.learning.train.exposition.config.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.diop.learning.rest.ConnectedManager;
import com.diop.learning.rest.Context;
import com.diop.learning.web.rest.jwt.JwtTools;



/**
 * Spring Security Filter
 * 
 * @author djibi
 *
 */
@Component
public class JwtSecurityFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtSecurityFilter.class);

	public static final String CLIENT_NUMBER = "clientNumber";

	@Autowired
	private JwtTools jwtTools;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// empty method
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOGGER.debug("Invoking doFilter");

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// extract connected id
		String connectedId = jwtTools.extractUserIdFromHeaderRequest(httpRequest);
		// Validate header data
		try {
			// get customer number connected

			LOGGER.info("connected Id received = {}", connectedId);

			String canal = jwtTools.extractChannelFromHeaderRequest(httpRequest);
			LOGGER.info("canal received = {}", canal);

			if (!Optional.ofNullable(connectedId).isPresent()) {
				SecurityContextHolder.clearContext();
				ConnectedManager.clear();
			}

			if (!Optional.ofNullable(canal).isPresent()) {
				SecurityContextHolder.clearContext();
				ConnectedManager.clear();
			}

			Optional.ofNullable(connectedId).ifPresent(p ->

			Optional.ofNullable(canal).ifPresent(cnl -> {

				LOGGER.debug("Validation of header is OK. ");
				Context context = new Context(connectedId, canal);
				ConnectedManager.set(context);

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("", null, Collections.emptyList());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			})

			);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("Unautaurized access with connectedId : {} and exception :  {}", connectedId, e);
			SecurityContextHolder.clearContext();
			ConnectedManager.clear();
		} finally {
			// continue through the filter chain
			chain.doFilter(request, response);
			SecurityContextHolder.clearContext();
			ConnectedManager.clear();
		}
	}

	@Override
	public void destroy() {
		// empty method
	}

}
