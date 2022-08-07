package com.example.nurmukhammad_internship_spring_data.security;

import com.example.nurmukhammad_internship_spring_data.Exceptions.JwtAuthenticationException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwTokenFilter extends GenericFilterBean {

    private final JwTokenProvider jwTokenProvider;

    @Autowired
    public JwTokenFilter(JwTokenProvider jwTokenProvider) {
        this.jwTokenProvider = jwTokenProvider;
    }


    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        String token = jwTokenProvider.resolveToken((HttpServletRequest) servletRequest);
        try {
            if (token != null && jwTokenProvider.validateToken(token)){
                Authentication authentication = jwTokenProvider.getAuthentication(token);
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (JwtAuthenticationException e) {
            SecurityContextHolder.clearContext();
            ((HttpServletResponse) servletResponse).sendError(e.getHttpStatus().value());
            throw new JwtAuthenticationException("JWT expired or invalid", HttpStatus.UNAUTHORIZED);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
