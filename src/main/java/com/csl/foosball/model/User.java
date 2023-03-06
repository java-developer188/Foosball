package com.csl.foosball.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements UserDetails{

	private static final long serialVersionUID = -3875769988396283999L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String password;
	
	@Column
	private String username;
	
	@Column
	private String role;
	
	@Column
	private boolean accountNonExpired;
	
	@Column
	private boolean accountNonLocked;
	
	@Column
	private boolean credentialsNonExpired;
	
	@Column
	private boolean enabled;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return role;
			}
		});
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return accountNonExpired ;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		
		return enabled;
	}

	
}
