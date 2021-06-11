package com.concesionarie.concesyonarye.segurity.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.concesionarie.concesyonarye.segurity.common.SecurityConstant;
import com.concesionarie.concesyonarye.segurity.filter.jwt.JWTTokenProvider;
import com.concesionarie.concesyonarye.segurity.model.dto.CustomerUserDto;
import com.concesionarie.concesyonarye.segurity.model.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class JWTAuthenticationFilter.
 */
@WebFilter
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	/** The authentication manager. */
	private static AuthenticationManager authenticationManager;
	
	/**
	 * Instantiates a new JWT authentication filter.
	 *
	 * @param authenticationManager the authentication manager
	 */
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(SecurityConstant.LOG_IN_URL);
    }
	

	/**
	 * Attempt authentication.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the authentication
	 * @throws AuthenticationException the authentication exception
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		CustomerUserDto user = null;
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), CustomerUserDto.class);
			

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return 	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), 
																						   user.getPassword()));
	}

	/**
	 * Successful authentication.
	 *
	 * @param request the request
	 * @param response the response
	 * @param chain the chain
	 * @param authResult the auth result
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
        response.getWriter().print(JWTTokenProvider.generateToken(((User)authResult.getPrincipal())));
	}
}
