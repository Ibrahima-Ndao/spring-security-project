package com.spring.security.jwt;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.spring.security.usersecurity.UserPrincipal;
import com.spring.security.util.SecurityUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JwtProvider implements IjwtProvider{
	@Value("${secrete.key}")
	private String secreteKey;
	
	@Value("${experation.time.millis}")
	private Long ExperationTime;
	
	@Override
	public String generateToken(UserPrincipal user) {
		String authorities = user.getAuthorities().stream()
								 .map(GrantedAuthority::getAuthority)
								 .collect(Collectors.joining(","));
		return Jwts.builder()
				.setSubject(user.getUsername())
				.claim("roles", authorities)
				.claim("userId", user.getId())
				.setExpiration(new Date(System.currentTimeMillis() + ExperationTime))
				.signWith(SignatureAlgorithm.HS512, secreteKey)
				.compact();
	}
	
	@Override
	public Authentication getAuthentication(HttpServletRequest request) {
		Claims claims = extractClaim(request);
		if (claims == null) {
			return null;
		}
		String username = claims.getSubject();
		Set<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
				.map(SecurityUtil::convertToGrantedAuthority)
				.collect(Collectors.toSet());
		Long userId = claims.get("userId", Long.class);
		UserDetails userDetails = new UserPrincipal(userId, username, authorities);
		if (username == null) {
			return null;
		}
		return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
	}
	
	@Override
	public boolean validateToken(HttpServletRequest request) {
		Claims claims = extractClaim(request);
		if (claims == null) {
			return false;
		}
		if(claims.getExpiration().before(new Date())) {
			return false;
		}
		return true;
	}
	
	public Claims extractClaim(HttpServletRequest request) {
		String token = SecurityUtil.extractToken(request);
		if (token == null) {
			return null;
		}
		return Jwts.parser()
					.setSigningKey(secreteKey)
					.parseClaimsJws(token)
					.getBody();
	}
	
}
