package dev.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {
	
	public UserDetails getUserDetails();
	
}
