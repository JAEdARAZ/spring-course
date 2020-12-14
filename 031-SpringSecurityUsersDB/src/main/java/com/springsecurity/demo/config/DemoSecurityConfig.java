package com.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//instance of DataSource Bean created in DemoAppConfig 
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Spring Security will use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//.anyRequest().authenticated() //in this case we want to limit depending on the role of the user
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/managerMenu/**").hasRole("MANAGER") //** will cover all subdirectories
			.antMatchers("/adminMenu/**").hasRole("ADMIN")
			.and()
			.formLogin() //customize the login
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll() //everyone will be able to access the login page
			.and()
			.logout().permitAll() //logout support
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied"); //request to show the customized screen of access denied
	}

}
