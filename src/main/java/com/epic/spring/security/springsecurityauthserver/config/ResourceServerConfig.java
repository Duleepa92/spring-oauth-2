/**
 * 
 */
package com.epic.spring.security.springsecurityauthserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Component;

/**
 * @author duleepa_w
 *
 */

@EnableResourceServer
@Configuration
@Component
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.requestMatchers()
				.antMatchers("/login", "/oauth/authorize")
			.and()
			.authorizeRequests()
				.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.permitAll();

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.parentAuthenticationManager(authenticationManagerBean())
		.inMemoryAuthentication()
		.withUser("Duleepa")
		.password("duleepa")
		.roles("USER");

	}

}
