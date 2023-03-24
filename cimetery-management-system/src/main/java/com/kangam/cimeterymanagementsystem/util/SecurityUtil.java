package com.kangam.cimeterymanagementsystem.util;

import com.kangam.cimeterymanagementsystem.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtil {
    public static final String  ROLE_PREFIX = "ROLE_";
    public static final String HEADER = "Authorization";
    public static final String TOKEN_TYPE = "Bearer";
    public static final String TOKEN_TYPE_PREFIX = TOKEN_TYPE + " ";
    public static SimpleGrantedAuthority convertToGranted(String role){
        String role_formatted = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return  new SimpleGrantedAuthority(role_formatted);
    }

    public static String extractToken(HttpServletRequest request){
        String bearerToken = request.getHeader(HEADER);
        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith(TOKEN_TYPE_PREFIX)){
            return bearerToken.substring(7);
        }
        return null;
    }
}
