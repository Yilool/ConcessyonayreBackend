package com.concesionarie.concesyonarye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// TODO: Auto-generated Javadoc
/**
 * The Class ConcesyonaryeApplication.
 */
@SpringBootApplication(scanBasePackages = {"com.*"})
public class ConcesyonaryeApplication extends SpringBootServletInitializer{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConcesyonaryeApplication.class, args);
	}
	
	/**
	 * Configure.
	 *
	 * @param application the application
	 * @return the spring application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConcesyonaryeApplication.class);
	}
}
