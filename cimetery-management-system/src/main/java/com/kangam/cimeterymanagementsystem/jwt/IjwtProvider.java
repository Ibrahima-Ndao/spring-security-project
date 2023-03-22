package com.kangam.cimeterymanagementsystem.jwt;

import com.kangam.cimeterymanagementsystem.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IjwtProvider {
    String generateToken(UserPrincipal principal);

    Authentication getauthentication(HttpServletRequest request);

    Boolean valdateToken(HttpServletRequest request);
}
