package com.poc5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Admin").password("{noop}admin").roles("ADMIN");
	}
	
	//Providing security for all pages except the home page
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/{spring:[a-z]+}").fullyAuthenticated().and().httpBasic();
	}
	
	//Providing security for update and delete pages
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests()
//			.antMatchers("/updateemployee**", "/deleteemployee**")
//			.hasAnyRole("ADMIN").anyRequest().fullyAuthenticated()
//			.and().httpBasic();
//	}
}

