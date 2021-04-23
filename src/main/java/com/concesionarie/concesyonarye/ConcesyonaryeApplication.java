package com.concesionarie.concesyonarye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EntityScan
@SpringBootApplication(scanBasePackages = {"com.*"})
public class ConcesyonaryeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcesyonaryeApplication.class, args);
	}

}
