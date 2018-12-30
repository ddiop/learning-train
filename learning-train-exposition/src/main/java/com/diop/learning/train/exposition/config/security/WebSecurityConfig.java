package com.diop.learning.train.exposition.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurity Configuration
 * 
 * @author djibi
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationProvider jwtAuthenticationProvider;
	@Autowired
	private JwtSecurityFilter jwtSecurityFilter;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(jwtAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().cacheControl();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll()

				.antMatchers("/bower_components/**", "/v2/api-docs", "/swagger-ui/**", "/configuration/ui/**", "/swagger-resources/**", "//configuration/security", "/swagger-ui/index.html", "/webjars/**").permitAll()

				.antMatchers("/api/property-loan/parameters/**").permitAll()

				.antMatchers(HttpMethod.OPTIONS).permitAll()

				.anyRequest().authenticated().and().addFilterBefore(jwtSecurityFilter, UsernamePasswordAuthenticationFilter.class).exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
	}
}
