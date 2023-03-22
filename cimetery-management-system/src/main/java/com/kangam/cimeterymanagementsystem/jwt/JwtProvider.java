package com.kangam.cimeterymanagementsystem.jwt;

import com.kangam.cimeterymanagementsystem.security.UserPrincipal;
import com.kangam.cimeterymanagementsystem.util.SecurityUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtProvider implements IjwtProvider{
    @Value("${jwt.secrete}")
    private String secrete_key;
    @Value("${jwt.expiration.time}")
    private Long jwt_expiration_time;
    @Override
    public String generateToken(UserPrincipal principal){
        String authorities = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .claim("userId", principal.getId())
                .claim("role", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + jwt_expiration_time))
                .signWith(SignatureAlgorithm.HS512, secrete_key)
                .compact();
    }
    @Override
    public Authentication getauthentication(HttpServletRequest request){
        Claims claims = extractClaim(request);
        if (claims == null){
            return null;
        }
        String username = claims.getSubject();
        Long userId = claims.get("userId", Long.class);
        Set<GrantedAuthority> authorities = Arrays.stream(claims.get("role").toString().split(","))
                .map(SecurityUtil::convertToGranted).collect(Collectors.toSet());
        UserDetails userDetails = UserPrincipal.builder().id(userId).username(username).authorities(authorities)
                .build();
        if (username == null){
            return null;
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
    }
    @Override
    public Boolean valdateToken(HttpServletRequest request){
        Claims claims = extractClaim(request);
        if (claims == null){
            return false;
        }
        if (claims.getExpiration().before(new Date())){
            return false;
        }
        return true;
    }
    public Claims extractClaim(HttpServletRequest  request){
        String token = SecurityUtil.extractToken(request);
        if (token == null){
            return null;
        }

        return Jwts.parser()
                .setSigningKey(secrete_key)
                .parseClaimsJws(token)
                .getBody();
    }
}
