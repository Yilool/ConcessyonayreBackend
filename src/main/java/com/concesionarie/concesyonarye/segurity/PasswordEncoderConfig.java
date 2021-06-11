package com.concesionarie.concesyonarye.segurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class PasswordEncoderConfig.
 */
@Configuration
public class PasswordEncoderConfig {
	
	/**
	 * Password enconder.
	 *
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
}
