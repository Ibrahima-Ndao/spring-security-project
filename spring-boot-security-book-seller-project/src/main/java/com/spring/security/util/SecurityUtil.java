package com.spring.security.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.SimpleGrantedAuthority;




public class SecurityUtil {
	public static final String ROLE_PREFIX = "ROLE_";
	public static final String AUTH = "authorization";
	public static final String AUTH_TYPE = "bearer";
	public static final String PREFIX_AUTH_TYPE = AUTH_TYPE + " ";
	
	public static SimpleGrantedAuthority convertToGrantedAuthority(String role) {
		String ROLE_FORMATTED = role.startsWith(ROLE_PREFIX)?role:ROLE_PREFIX + role;
		return new SimpleGrantedAuthority(ROLE_FORMATTED);
	}
	
	public static String extractToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTH);
		if(bearerToken.length() > 0 && !bearerToken.trim().isBlank() && bearerToken.startsWith(PREFIX_AUTH_TYPE)) {
			return bearerToken.substring(7);
		}
		return null;
	}
}
