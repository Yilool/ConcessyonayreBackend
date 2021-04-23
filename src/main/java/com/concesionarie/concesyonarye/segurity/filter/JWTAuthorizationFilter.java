package com.concesionarie.concesyonarye.segurity.filter;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.concesionarie.concesyonarye.segurity.common.SecurityConstant;
import com.concesionarie.concesyonarye.segurity.filter.jwt.JWTTokenProvider;
import com.concesionarie.concesyonarye.segurity.model.entity.User;
import com.concesionarie.concesyonarye.segurity.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
@WebFilter
public class JWTAuthorizationFilter extends OncePerRequestFilter{
	@Autowired
	private UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader(SecurityConstant.HEADER);

        if (header == null || !header.startsWith(SecurityConstant.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        //ToDo 
        //Manage exceptions
        authentication.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
	}
	
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstant.HEADER).replace(SecurityConstant.TOKEN_PREFIX, "");
        UsernamePasswordAuthenticationToken upat = null;
        
        if (token != null && !token.isEmpty() && JWTTokenProvider.validateToken(token)) {
        	try {
        		Integer idUser = Integer.valueOf(Jwts.parser().
        									setSigningKey(Keys.hmacShaKeyFor(SecurityConstant.SECRET.getBytes()))
        									.parseClaimsJws(token)
        									.getBody()
        									.getId());
        	
				User user = (User) userService.loadUserById(idUser);
				if (idUser != null) {
					upat=  new UsernamePasswordAuthenticationToken(idUser, user.getRoles(), user.getAuthorities());
				}
			} catch (AuthenticationException e) {
				throw new RuntimeException("No user identifier has been found in the request");
			}
        }
        return upat;	
    }
}
