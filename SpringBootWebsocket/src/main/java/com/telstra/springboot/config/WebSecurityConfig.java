package com.telstra.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import waffle.servlet.spi.SecurityFilterProviderCollection;
import waffle.spring.NegotiateSecurityFilter;
import waffle.spring.NegotiateSecurityFilterEntryPoint;
import waffle.windows.auth.IWindowsAuthProvider;
import waffle.windows.auth.impl.WindowsAuthProviderImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		IWindowsAuthProvider waffleAuthProvider = new WindowsAuthProviderImpl();
	
		SecurityFilterProviderCollection provider = new SecurityFilterProviderCollection(waffleAuthProvider);
		NegotiateSecurityFilterEntryPoint entryPoint = new NegotiateSecurityFilterEntryPoint();
		entryPoint.setProvider(provider);
		
		NegotiateSecurityFilter securityFilter = new NegotiateSecurityFilter();
		securityFilter.setRoleFormat("both");
		securityFilter.setPrincipalFormat("fqn");
		securityFilter.setAllowGuestLogin(false);
		securityFilter.setProvider(provider);
				
		http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')").anyRequest().authenticated().and()
				.addFilterAfter(securityFilter, BasicAuthenticationFilter.class).exceptionHandling()
				.authenticationEntryPoint(entryPoint);
	}

}