package com.csl.foosball.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserDetailsService userDetailsService;

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
//		
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.authorizeHttpRequests()
//		.requestMatchers("/auth/**").permitAll()
//		.requestMatchers("/resource/**").authenticated()
//		.requestMatchers("/admin/**").hasRole("Admin")
//		.requestMatchers("/user/**").hasRole("User")
////		.and()
////		.httpBasic() 
//		.and()
//		.authenticationManager(authenticationManager(http));
//		
//		return http.build();
//	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/player/admin").hasRole("ADMIN")
					.requestMatchers("/player/user").hasAnyRole("ADMIN","USER")
					.requestMatchers("/**").permitAll()			
			)
			.formLogin();
			

		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder())
				.and().build();
	}
	

	
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailManager() {
//		UserDetails admin = User.withUsername("admin")
//				.password("12345")
//				.roles("Admin")
//				.build();
//		
//		
//		
//		UserDetails user = User.withUsername("User")
//				.password("12345")
//				.roles("User")
//				.build();
//		
//		return new InMemoryUserDetailsManager(admin,user);
//	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
