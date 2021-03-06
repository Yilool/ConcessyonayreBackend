package com.concesionarie.concesyonarye.segurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.concesionarie.concesyonarye.segurity.common.SecurityConstant;
import com.concesionarie.concesyonarye.segurity.filter.JWTAuthenticationFilter;
import com.concesionarie.concesyonarye.segurity.filter.JWTAuthorizationFilter;
import com.concesionarie.concesyonarye.segurity.model.enumerate.UserRoles;
import com.concesionarie.concesyonarye.segurity.service.UserService;


// TODO: Auto-generated Javadoc
/**
 * The Class WebSecurityConfig.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/** The jwt authorization filter. */
	@Autowired
	private JWTAuthorizationFilter jwtAuthorizationFilter;
	
	/** The user service. */
	@Autowired
	private UserService userService;
	
	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * Authentication manager bean.
	 *
	 * @return the authentication manager
	 * @throws Exception the exception
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	       http.cors().and().csrf().disable().authorizeRequests()
           					.antMatchers(HttpMethod.POST, SecurityConstant.SIGN_UP_URL).permitAll()
           					.antMatchers(HttpMethod.POST, SecurityConstant.SIGN_IN_URL).permitAll()
           					.antMatchers(HttpMethod.POST, SecurityConstant.LOG_IN_URL).permitAll()
           					.antMatchers(HttpMethod.GET, "/user").hasRole(UserRoles.ADMIN.name())
           					.antMatchers(HttpMethod.DELETE, "/user").hasRole(UserRoles.ADMIN.name())
           					.antMatchers(HttpMethod.GET, "/roles").hasRole(UserRoles.ADMIN.name())
           					.antMatchers(HttpMethod.POST, "/model").hasRole(UserRoles.MECHANIC.name())
           					.antMatchers(HttpMethod.DELETE, "/model").hasRole(UserRoles.MECHANIC.name())
           					.antMatchers(HttpMethod.GET, "/model").permitAll()
           					.antMatchers(HttpMethod.POST, "/category").hasRole(UserRoles.MECHANIC.name())
           					.antMatchers(HttpMethod.DELETE, "/category").hasRole(UserRoles.MECHANIC.name())
           					.antMatchers(HttpMethod.GET, "/category").permitAll()
           					.antMatchers(HttpMethod.POST, "/brand").hasRole(UserRoles.MECHANIC.name())
           					.antMatchers(HttpMethod.DELETE, "/brand").hasRole(UserRoles.MECHANIC.name())
           					.antMatchers(HttpMethod.GET, "/brand").permitAll()
           					.antMatchers(HttpMethod.POST, "/vehicle").hasRole(UserRoles.MECHANIC.name())
           					.antMatchers(HttpMethod.GET, "/vehicle").permitAll()
           					.antMatchers(HttpMethod.POST, "/promotion").hasRole(UserRoles.ADMIN.name())
           					.antMatchers(HttpMethod.DELETE, "/promotion").hasRole(UserRoles.ADMIN.name())
           					.antMatchers(HttpMethod.GET, "/promotion").permitAll()
           					.antMatchers(HttpMethod.GET, "/purchase").hasRole(UserRoles.SELLER.name())
           					.antMatchers(HttpMethod.POST, "/purchase").hasRole(UserRoles.SELLER.name())
           					.anyRequest().authenticated()
           				.and()
           					.addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
           					.addFilterBefore(jwtAuthorizationFilter, BasicAuthenticationFilter.class)
           				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	/**
	 * Configure.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}
